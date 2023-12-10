/*
 * Copyright (C) 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package api;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.atlasmap.api.AtlasContext;
import io.atlasmap.api.AtlasContextFactory;
import io.atlasmap.api.AtlasSession;
import io.atlasmap.core.DefaultAtlasContext;
import io.atlasmap.core.DefaultAtlasContextFactory;
import org.json.JSONObject;
//
//public class AtlasMapper {
//
//    public static void main(String args[]) throws Exception {
//        AtlasMapper m = new AtlasMapper();
//        m.process();
//    }
//
//    public void process() throws Exception {
//        AtlasContextFactory factory = DefaultAtlasContextFactory.getInstance();
//        //File mappingFile = new File("D:/Atlasmap/Workspace/json_json/json_json_mapping.adm");
//        //File mappingFile = new File("D:/Atlasmap/Workspace/json_xml/equifax-fullmapping.adm");
////        File mappingFile = new File("C:\\Users\\rajkumar_p\\Documents\\status\\atlasmap-mapping (2).adm");
//        File mappingFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\atlasmap-mapping (4).adm");
//        AtlasContext context = factory.createContext(mappingFile.toURI());
//        AtlasSession session = context.createSession();
//        session.getTargetProperties();
//        
//        //File inputFile = new File("D:/Atlasmap/Workspace/json_json/source_equifax_json.json");
//        File inputFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\xml_jsonV3\\equifax_json.json");
////        File inputFile = new File("C:\\\\Users\\\\rajkumar_p\\\\Videos\\\\xml_jsonV32\\\\xml_jsonV3\\\\equifax_requestMin.xml");
//        String source = new String(Files.readAllBytes(inputFile.toPath()));
//        System.out.println("Source document:\n" + source);   
//        session.setSourceDocument("JSONSchemaSource", source);
//        context.process(session);
//        String targetDoc = (String) session.getDefaultTargetDocument();
//        if(isXML(targetDoc)) {
//        	printXML(targetDoc);
//        }else if(isJSON(targetDoc)){
//        	printJSON(targetDoc);
//        }
//
//    }
//    
//    private static boolean isXML(String fileContent) throws ParserConfigurationException, SAXException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        try {
//			return builder.parse(new ByteArrayInputStream(fileContent.getBytes())).getDocumentElement() != null;
//		} catch (SAXException e) {
//			return false;
//		} catch (IOException e) {
//			return false;
//		}
//    }
//
//    private static boolean isJSON(String fileContent) {
//        try {
//            new JSONObject(fileContent);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//    
//
//    private void printXML(String targetDoc) throws Exception {
//        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//        StringWriter writer = new StringWriter();
//        transformer.transform(new StreamSource(new StringReader((String)targetDoc)), new StreamResult(writer));
//        System.out.println("Target Document:\n" + writer.toString());
//    }
//    
//    private void printJSON(String jsonString) throws Exception {
//    	ObjectMapper mapper = new ObjectMapper();
//        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonString);
//        System.out.println("Target Document:\n" +prettyJson);
//    }
//}



public class AtlasMapper {

    public static void main(String args[]) throws Exception {
        AtlasMapper m = new AtlasMapper();
        m.process();
    }

    public void process() throws Exception {
        AtlasContextFactory factory = DefaultAtlasContextFactory.getInstance();
        //File mappingFile = new File("D:/Atlasmap/Workspace/json_json/json_json_mapping.adm");
        //File mappingFile = new File("D:/Atlasmap/Workspace/json_xml/equifax-fullmapping.adm");
//        File mappingFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\atlasmap-mapping (5).adm");
//        File mappingFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV3\\atlasmap-3829.adm");
        File mappingFile = new File("C:\\Users\\rajkumar_p\\Downloads\\rajkumar.adm");
        AtlasContext context = factory.createContext(mappingFile.toURI());
        AtlasSession session = context.createSession();

        
        //File inputFile = new File("D:/Atlasmap/Workspace/json_json/source_equifax_json.json");
//        File inputFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\xml_jsonV3\\equifax_json.json");
//        File inputFile = new File("C:\\\\Users\\\\rajkumar_p\\\\Videos\\\\xml_jsonV3\\atlasmap-3829-source.json");
        File inputFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\xml_jsonV3\\equifax_requestMin.xml");
//        FileInputStream input = new FileInputStream(inputFile);
//
//        StringBuilder buf = new StringBuilder();
//         create an object of bufferedReader to read
//         lines from file
        
//        BufferedReader r = new BufferedReader(new InputStreamReader(input));
//        String line;
//        while((line = r.readLine()) != null) {
//            buf.append(line);
//        }
//        r.close();

        String source = new String(Files.readAllBytes(inputFile.toPath()));
        System.out.println("Source document:\n" + session.getTargetProperties());   
        session.setSourceDocument("XMLSource",  source);
        context.process(session);
        String targetDoc = (String) session.getDefaultTargetDocument();
        System.out.println("Source document:\n" + targetDoc); 
        if(isXML(targetDoc)) {
        	printXML(targetDoc);
        }else if(isJSON(targetDoc)){
        	printJSON(targetDoc);	
        }

    }
    
    private static boolean isXML(String fileContent) throws ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try {
			return builder.parse(new ByteArrayInputStream(fileContent.getBytes())).getDocumentElement() != null;
		} catch (SAXException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
    }

    private static boolean isJSON(String fileContent) {
        try {
            new JSONObject(fileContent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

    private void printXML(String targetDoc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        StringWriter writer = new StringWriter();
        transformer.transform(new StreamSource(new StringReader((String)targetDoc)), new StreamResult(writer));
        System.out.println("Target Document:\n" + writer.toString());
    }
    
    private void printJSON(String jsonString) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonString);
        System.out.println("Target Document:\n" +prettyJson);
    }
}



//
//public class AtlasMapper {
//
//    public static void main(String args[]) throws Exception {
//        AtlasMapper m = new AtlasMapper();
//        m.process();
//    }
//
//    public void process() throws Exception {
//        AtlasContextFactory factory = DefaultAtlasContextFactory.getInstance();
//        //File mappingFile = new File("D:/Atlasmap/Workspace/json_json/json_json_mapping.adm");
//        //File mappingFile = new File("D:/Atlasmap/Workspace/json_xml/equifax-fullmapping.adm");
//        //File mappingFile = new File("D:/Atlasmap/Workspace/xml_json/xml_json_mapping.adm");
//        File mappingFile = new File("C:\\Users\\rajkumar_p\\Documents\\status\\atlasmap-mapping (2).adm");
//        AtlasContext context = factory.createContext(mappingFile);
//        AtlasSession session = context.createSession();
//        
//        System.out.println("my" + session.getTargetProperties());  
//        //File inputFile = new File("D:/Atlasmap/Workspace/json_json/source_equifax_json.json");
////        File inputFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\xml_jsonV3\\equifax_json.json");
//        File inputFile = new File("C:\\Users\\rajkumar_p\\Videos\\xml_jsonV32\\xml_jsonV3\\equifax_requestMin.xml");
//        String source = new String(Files.readAllBytes(inputFile.toPath()));
//        
////       
//        session.setSourceDocument("XmlSource", source);
//        context.process(session);
//        System.out.println("new"+session);
//        String targetDoc = (String) session.getDefaultTargetDocument();
//        if(isXML(targetDoc)) {
//        	printXML(targetDoc);
//        }else if(isJSON(targetDoc)){
//        	printJSON(targetDoc);
//        }
//
//    }
//    
//    private static boolean isXML(String fileContent) throws ParserConfigurationException, SAXException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        try {
//			return builder.parse(new ByteArrayInputStream(fileContent.getBytes())).getDocumentElement() != null;
//		} catch (SAXException e) {
//			return false;
//		} catch (IOException e) {
//			return false;
//		}
//    }
//
//    private static boolean isJSON(String fileContent) {
//        try {
//            new JSONObject(fileContent);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//    
//
//    private void printXML(String targetDoc) throws Exception {
//        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//        StringWriter writer = new StringWriter();
//        transformer.transform(new StreamSource(new StringReader((String)targetDoc)), new StreamResult(writer));
//        System.out.println("Target Document:\n" + writer.toString());
//    }
//    
//    private void printJSON(String jsonString) throws Exception {
//    	ObjectMapper mapper = new ObjectMapper();	
//        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonString);
//        System.out.println("Target Document:\n" +prettyJson);
//    }
//}
