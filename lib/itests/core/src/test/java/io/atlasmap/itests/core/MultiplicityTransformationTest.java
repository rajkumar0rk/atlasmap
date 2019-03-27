/**
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
package io.atlasmap.itests.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.atlasmap.api.AtlasContext;
import io.atlasmap.api.AtlasSession;
import io.atlasmap.core.AtlasMappingService;
import io.atlasmap.core.DefaultAtlasContextFactory;
import io.atlasmap.itests.core.issue.SourceClass;
import io.atlasmap.itests.core.issue.TargetClass;
import io.atlasmap.v2.AtlasMapping;

public class MultiplicityTransformationTest {

    private AtlasMappingService mappingService;

    @Before
    public void before() {
        mappingService = DefaultAtlasContextFactory.getInstance().getMappingService();
    }

    @Test
    public void testConcatenateSplit() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("mappings/atlasmapping-multiplicity-transformation-concatenate-split.json");
        AtlasMapping mapping = mappingService.loadMapping(url);
        AtlasContext context = DefaultAtlasContextFactory.getInstance().createContext(mapping);
        AtlasSession session = context.createSession();
        SourceClass source = new SourceClass()
                .setSourceFirstName("Manjiro")
                .setSourceLastName("Nakahama")
                .setSourceName("Manjiro,Nakahama")
                .setSourceString("one,two,three")
                .setSourceStringList(Arrays.asList(new String[] {"one", "two", "three"}));
        session.setSourceDocument("io.atlasmap.itests.core.issue.SourceClass", source);
        context.process(session);
        assertFalse(TestHelper.printAudit(session), session.hasErrors());
        assertFalse(TestHelper.printAudit(session), session.hasWarns());
        Object output = session.getTargetDocument("io.atlasmap.itests.core.issue.TargetClass");
        assertEquals(TargetClass.class, output.getClass());
        TargetClass target = TargetClass.class.cast(output);
        assertEquals("Manjiro", target.getTargetFirstName());
        assertEquals("Nakahama", target.getTargetLastName());
        assertEquals("Manjiro,Nakahama", target.getTargetName());
        assertEquals("one,two,three", target.getTargetString());
        List<String> list = target.getTargetStringList();
        assertEquals(3, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
    }

    @Test
    public void testItemAt() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("mappings/atlasmapping-multiplicity-transformation-itemAt.json");
        AtlasMapping mapping = mappingService.loadMapping(url);
        AtlasContext context = DefaultAtlasContextFactory.getInstance().createContext(mapping);
        AtlasSession session = context.createSession();
        SourceClass source = new SourceClass().setSourceStringList(Arrays.asList(new String[] {"one", "two", "three"}));
        session.setSourceDocument("io.atlasmap.itests.core.issue.SourceClass", source);
        context.process(session);
        assertFalse(TestHelper.printAudit(session), session.hasErrors());
        assertFalse(TestHelper.printAudit(session), session.hasWarns());
        Object output = session.getTargetDocument("io.atlasmap.itests.core.issue.TargetClass");
        assertEquals(TargetClass.class, output.getClass());
        TargetClass target = TargetClass.class.cast(output);
        assertEquals("two", target.getTargetString());
    }
}
