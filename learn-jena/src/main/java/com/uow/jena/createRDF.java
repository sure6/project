package com.uow.jena;

import org.apache.jena.atlas.web.TypedInputStream;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.VCARD;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


public class createRDF {
    // some definitions
    static String personURI = "http://somewhere/JohnSmith";
    static String familyName = "Smith";
    static String givenName = "John";
    static String fullName = givenName + " " + familyName;

    private static String filePath="C:\\idea-workspaces\\project\\learn-jena\\src\\main\\java\\com\\uow\\jena\\";
    private static String fileName="vc-db-1.rdf";

    public static void main(String[] args) {
        // create an empty Model
        Model model = ModelFactory.createDefaultModel();

        model.createResource(personURI).addProperty(VCARD.FN, fullName).
                addProperty(VCARD.N,
                        model.createResource().addProperty(VCARD.Given, givenName).addProperty(VCARD.Family, familyName));
        // list the statements in the Model
        StmtIterator iter = model.listStatements();

        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement(); // get next statement
            Resource subject = stmt.getSubject(); // get the subject
            Property predicate = stmt.getPredicate(); // get the predicate
            RDFNode object = stmt.getObject(); // get the object

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                // object id a literal
                System.out.print("\"" + object.toString() + "\"");
            }

            System.out.println(".");
        }
        System.out.println("----------RDF/XML--------------");
        try {
            RDFDataMgr.write(new FileWriter(filePath + fileName),model, Lang.RDFXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = RDFDataMgr.open(filePath + fileName);
        if (is == null) {
            throw new IllegalArgumentException("File:" + filePath + fileName + " not found");
        }

        model.read(is,null);
        model.write(System.out);
        System.out.println("----------RDF/turtle--------------");
        RDFDataMgr.write(System.out,model, Lang.TURTLE);
        System.out.println("-----------RDF/N-triples---------------");
        RDFDataMgr.write(System.out,model, Lang.NTRIPLES);

        System.out.println("-----------RDF模型的信息访问（Navigating and Querying）---------------");
        // retrieve the Adam Smith vcard resource from the model
        Resource vcard = model.getResource(personURI);
        // retrieve the values of the N property
        Resource name = (Resource) vcard.getRequiredProperty(VCARD.N).getObject();
        // retrieve the given name property
        String fullName = vcard.getRequiredProperty(VCARD.FN).getString();
        // add two nick name properties to vcard
        vcard.addProperty(VCARD.NICKNAME, "Smith")
                .addProperty(VCARD.NICKNAME, "Adman");

        // set up the output
        System.out.println("The nicknames of \"" + fullName + "\" are:");
        // list the nicknames
        StmtIterator iter2 = vcard.listProperties(VCARD.NICKNAME);
        while (iter2.hasNext()) {
            System.out.println("    " + iter2.nextStatement().getObject().toString());
        }
    }
}
