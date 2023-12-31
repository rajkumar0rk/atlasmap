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
package io.atlasmap.itests.reference.xml_to_xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import io.atlasmap.api.AtlasContext;
import io.atlasmap.api.AtlasSession;
import io.atlasmap.itests.reference.AtlasMappingBaseTest;
import io.atlasmap.itests.reference.AtlasTestUtil;

public class XmlXmlFlatMappingTest extends AtlasMappingBaseTest {

    @Test
    public void testProcessXmlXmlFlatPrimitiveAttributeToElementNS() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-attributeToElement-ns.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-attribute-ns.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        AtlasTestUtil.validateXmlFlatPrimitiveElement(object);
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveAttributeToElementNoMappedBoxedFieldsNS() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-attributeToElement-noboxed-ns.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-attribute-ns.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        AtlasTestUtil.validateXmlFlatPrimitiveElement(object);
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveElementToAttributeNS() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-elementToAttribute-ns.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-element-ns.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        AtlasTestUtil.validateXmlFlatPrimitiveAttribute(object);
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveElementToAtributeNoMappedBoxedFieldsNS() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-elementToAttribute-noboxed-ns.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-element-ns.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        AtlasTestUtil.validateXmlFlatPrimitiveAttribute(object);
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveAttributeToElement() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-attributeToElement.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-attribute.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><XmlFPE><intField>2</intField><shortField>1</shortField><longField>30000</longField><doubleField>50000000.0</doubleField><floatField>40000000.0</floatField><booleanField>false</booleanField><charField>a</charField><byteField>99</byteField><boxedBooleanField/><boxedByteField/><boxedCharField/><boxedDoubleField/><boxedFloatField/><boxedIntField/><boxedLongField/><boxedStringField/></XmlFPE>",
                object);
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveAttributeToElementNoBoxed() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-attributeToElement-noboxed.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-attribute.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><XmlFPE><intField>2</intField><shortField>1</shortField><longField>30000</longField><doubleField>50000000.0</doubleField><floatField>40000000.0</floatField><booleanField>false</booleanField><charField>a</charField><byteField>99</byteField></XmlFPE>",
                object);
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveElementToAttribute() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-elementToAttribute.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-element.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><XmlFPA booleanField=\"false\" boxedBooleanField=\"false\" boxedByteField=\"99\" boxedCharField=\"a\" boxedDoubleField=\"50000000.0\" boxedFloatField=\"40000000.0\" boxedIntField=\"2\" boxedLongField=\"30000\" boxedStringField=\"foobar\" byteField=\"99\" charField=\"a\" doubleField=\"50000000.0\" floatField=\"40000000.0\" intField=\"2\" longField=\"30000\" shortField=\"1\"/>",
                object,
                object.toString());
    }

    @Test
    public void testProcessXmlXmlFlatPrimitiveElementToAttributeNoBoxed() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-flatprimitive-elementToAttribute-noboxed.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-flatprimitive-element.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><XmlFPA booleanField=\"false\" byteField=\"99\" charField=\"a\" doubleField=\"50000000.0\" floatField=\"40000000.0\" intField=\"2\" longField=\"30000\" shortField=\"1\"/>",
                object);
    }

    @Test
    public void testProcessXmlXmlBoxedFlatMappingPrimitiveAttributeToElement() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-boxedflatprimitive-attributeToElement.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-boxedflatprimitive-attribute.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><XmlFBPE><boxedIntField>5</boxedIntField><boxedShortField>5</boxedShortField><boxedLongField>20000</boxedLongField><boxedDoubleField>90000000.0</boxedDoubleField><boxedFloatField>70000000.0</boxedFloatField><boxedBooleanField>true</boxedBooleanField><boxedCharField>z</boxedCharField><boxedByteField>87</boxedByteField></XmlFBPE>",
                object);
    }

    @Test
    public void testProcessXmlXmlBoxedFlatMappingPrimitiveAttributeToElementNS() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-boxedflatprimitive-attributeToElement-ns.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-boxedflatprimitive-attribute-ns.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        AtlasTestUtil.validateXmlFlatPrimitiveBoxedPrimitiveElementFields(object);
    }

    @Test
    public void testProcessXmlXmlBoxedFlatMappingPrimitiveElementToAttribute() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-boxedflatprimitive-elementToAttribute.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-boxedflatprimitive-element.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><XmlFBPA boxedBooleanField=\"true\" boxedByteField=\"87\" boxedCharField=\"z\" boxedDoubleField=\"90000000.0\" boxedFloatField=\"70000000.0\" boxedIntField=\"5\" boxedLongField=\"20000\" boxedShortField=\"5\"/>",
                object);
    }

    @Test
    public void testProcessXmlXmlBoxedFlatMappingPrimitiveElementToAttributeNS() throws Exception {
        AtlasContext context = atlasContextFactory.createContext(
                new File("src/test/resources/xmlToXml/atlasmapping-boxedflatprimitive-elementToAttribute-ns.json"));

        AtlasSession session = context.createSession();
        String sourceXml = AtlasTestUtil
                .loadFileAsString("src/test/resources/xmlToXml/atlas-xml-boxedflatprimitive-element-ns.xml");
        session.setDefaultSourceDocument(sourceXml);
        context.process(session);

        assertFalse(session.hasErrors(), printAudit(session));
        Object object = session.getDefaultTargetDocument();
        assertNotNull(object);
        assertTrue(object instanceof String);
        AtlasTestUtil.validateXmlFlatPrimitiveBoxedPrimitiveAttributeFields(object);
    }
}
