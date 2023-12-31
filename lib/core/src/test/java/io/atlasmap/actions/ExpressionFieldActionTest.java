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
package io.atlasmap.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import io.atlasmap.v2.Expression;

public class ExpressionFieldActionTest {

    /*
     * functions
     */

    @Test
    public void testIF() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} == ${1}, 'same', 'not same')");
        assertEquals("same", ExpressionFieldAction.process(action, Arrays.asList(10, 10)));
        assertEquals("not same", ExpressionFieldAction.process(action, Arrays.asList(100, 10)));
    }

    @Test
    public void testIFInteger() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} == 123, 123, 456)");
        assertEquals(123, ExpressionFieldAction.process(action, Arrays.asList(123)));
        assertEquals(456, ExpressionFieldAction.process(action, Arrays.asList(789)));
    }

    @Test
    public void testIFIntegerZero() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} == 0, 0, 1)");
        assertEquals(0, ExpressionFieldAction.process(action, Arrays.asList(0)));
        assertEquals(1, ExpressionFieldAction.process(action, Arrays.asList(1)));
    }

    @Test
    public void testGT() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} > ${1}, ${0}, ${1})");
        assertEquals(1000, ExpressionFieldAction.process(action, Arrays.asList(1000, 100)));
        assertEquals(10000, ExpressionFieldAction.process(action, Arrays.asList(1000, 10000)));
        assertEquals(10, ExpressionFieldAction.process(action, Arrays.asList(10, -10)));
    }

    @Test
    public void testLT() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(LT(${0}, ${1}), ${0}, ${1})");
        assertEquals(10, ExpressionFieldAction.process(action, Arrays.asList(10, 100)));
        assertEquals(100, ExpressionFieldAction.process(action, Arrays.asList(1000, 100)));
        assertEquals(-10, ExpressionFieldAction.process(action, Arrays.asList(10, -10)));
        action.setExpression("IF(${0} < ${1}, ${0}, ${1})");
        assertEquals(10, ExpressionFieldAction.process(action, Arrays.asList(10, 100)));
        assertEquals(100, ExpressionFieldAction.process(action, Arrays.asList(1000, 100)));
        assertEquals(-10, ExpressionFieldAction.process(action, Arrays.asList(10, -10)));
    }

    @Test
    public void testTOLOWER() throws Exception {
        Expression action = new Expression();
        action.setExpression("TOLOWER(${0})");
        assertEquals("qwerty", ExpressionFieldAction.process(action, Arrays.asList("qWeRtY")));
    }

    @Test
    public void testISEMPTY() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(ISEMPTY(${0}), 'empty', 'not empty')");
        assertEquals("empty", ExpressionFieldAction.process(action, Arrays.asList((Object)null)));
        assertEquals("empty", ExpressionFieldAction.process(action, Arrays.asList("")));
        assertEquals("not empty", ExpressionFieldAction.process(action, Arrays.asList(" ")));
    }

    /*
     * operators
     */
    @Test
    public void testAdd() throws Exception {
        Expression action = new Expression();
        action.setExpression("${0} + ${1}");
        assertEquals(110, ExpressionFieldAction.process(action, Arrays.asList(10,100)));
        assertEquals("foobar", ExpressionFieldAction.process(action, Arrays.asList("foo","bar")));
    }

    @Test
    public void testSubtract() throws Exception {
        Expression action = new Expression();
        action.setExpression("${0} - ${1}");
        assertEquals(90, ExpressionFieldAction.process(action, Arrays.asList(100,10)));
    }

    @Test
    public void testMultiply() throws Exception {
        Expression action = new Expression();
        action.setExpression("${0} * ${1}");
        assertEquals(1000, ExpressionFieldAction.process(action, Arrays.asList(100,10)));
    }

    @Test
    public void testDivide() throws Exception {
        Expression action = new Expression();
        action.setExpression("${0} / ${1}");
        assertEquals(10.0, ExpressionFieldAction.process(action, Arrays.asList(100,10)));
    }

    @Test
    public void testAnd() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} == ${1} && ${0} == ${2}, 'all same', 'not all same')");
        assertEquals("all same", ExpressionFieldAction.process(action, Arrays.asList("foo","foo", "foo")));
        assertEquals("all same", ExpressionFieldAction.process(action, Arrays.asList(1, 1, 1)));
        assertEquals("not all same", ExpressionFieldAction.process(action, Arrays.asList("foo","foo", "fo")));
        assertEquals("not all same", ExpressionFieldAction.process(action, Arrays.asList(1, 1, 2)));
    }

    @Test
    public void testOr() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} == ${1} || ${0} == ${2}, 'some of them are same', 'all different')");
        assertEquals("some of them are same", ExpressionFieldAction.process(action, Arrays.asList("foo","foo", "fo")));
        assertEquals("some of them are same", ExpressionFieldAction.process(action, Arrays.asList(1, 1, 2)));
        assertEquals("all different", ExpressionFieldAction.process(action, Arrays.asList("foo","foo0", "fo")));
        assertEquals("all different", ExpressionFieldAction.process(action, Arrays.asList(1, 3, 2)));
    }

    @Test
    public void testNot() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(!ISEMPTY(${0}), 'not empty', 'empty')");
        assertEquals("not empty", ExpressionFieldAction.process(action, Arrays.asList("foo")));
        assertEquals("not empty", ExpressionFieldAction.process(action, Arrays.asList(" ")));
        assertEquals("empty", ExpressionFieldAction.process(action, Arrays.asList("")));
        assertEquals("empty", ExpressionFieldAction.process(action, Arrays.asList((Object)null)));
    }

    @Test
    public void testNull() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(${0} == null, 'null', 'not null')");
        assertEquals("null", ExpressionFieldAction.process(action, Arrays.asList((Object)null)));
        assertEquals("not null", ExpressionFieldAction.process(action, Arrays.asList("")));
    }

    @Test
    public void testEmptyExpression() throws Exception {
        Expression action = new Expression();
        action.setExpression(null);
        assertEquals(null, ExpressionFieldAction.process(action, null));
        action.setExpression("");
        assertEquals(null, ExpressionFieldAction.process(action, null));
        action.setExpression("   ");
        assertEquals(null, ExpressionFieldAction.process(action, null));
    }

    @Test
    public void testNumberField() throws Exception {
        Expression action = new Expression();
        Number integer = 1;
        action.setExpression("IF(${0} == 1, '1', 'not 1')");
        assertEquals("1", ExpressionFieldAction.process(action, Arrays.asList(integer)));
        BigInteger bigInt = new BigInteger("1");
        action.setExpression("IF(${0} == 1, 'bigint 1', 'not bigint 1')");
        assertEquals("bigint 1", ExpressionFieldAction.process(action, Arrays.asList(bigInt)));
        BigDecimal bigDec = new BigDecimal("1");
        action.setExpression("IF(${0} == 1, 'bigdecimal 1', 'not bigdecimal 1')");
        assertEquals("bigdecimal 1", ExpressionFieldAction.process(action, Arrays.asList(bigDec)));
    }

    @Test
    public void testConcatenateActionWithDelimiter() throws Exception {
        Expression action = new Expression();
        action.setExpression("CONCATENATE(${0}, ${1}, ${2}, ${3}, ${4})");
        assertEquals("a,b,c", ExpressionFieldAction.process(action, Arrays.asList(",", true, "a", "b", "c")));
    }

    @Test
    public void testConcatenateActionWithMissingArguments() throws Exception {
        Expression action = new Expression();
        action.setExpression("CONCATENATE(${0}, ${1})");
        try {
            ExpressionFieldAction.process(action, Arrays.asList(",", true));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("The transformation 'CONCATENATE' expects more arguments", e.getMessage());
        }
    }

    @Test
    public void testAddNestedAction() throws Exception {
        Expression action = new Expression();
        action.setExpression("IF(ADD(${0}, ${1}, ${2}) == ${3}, 'pass', 'fail')");
        assertEquals("pass", ExpressionFieldAction.process(action, Arrays.asList(1, 2, 3, 6)));
    }

}
