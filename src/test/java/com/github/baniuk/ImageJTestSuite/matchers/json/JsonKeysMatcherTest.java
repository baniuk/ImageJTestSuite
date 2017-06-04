package com.github.baniuk.ImageJTestSuite.matchers.json;

import static com.github.baniuk.ImageJTestSuite.matchers.json.JsonMatchers.haveSameKeys;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * @author p.baniukiewicz
 *
 */
public class JsonKeysMatcherTest {

  /**
   * Same keys, different vals
   * 
   * @throws Exception Exception
   */
  @Test
  public void testHaveSameKeys_same() throws Exception {
    //!>
    String json1 = "{\"menu\": {"+
                     " \"id\": \"file\","+
                      "\"value\": \"Fileeeee\","+
                      "\"popup\": {"+
                        "\"menuitem\": ["+
                             "{\"value\": \"Neweee\", \"onclick\": \"CreateNewDoc()\"},"+
                             "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"+
                             "{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"+
                        "]"+
                      "}"+
                   "}}";
    String json2 = "{\"menu\": {"+
            " \"id\": \"file\","+
             "\"value\": \"File\","+
             "\"popup\": {"+
               "\"menuitem\": ["+
                    "{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},"+
                    "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"+
                    "{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"+
               "]"+
             "}"+
          "}}";
    //!<
    assertThat(json1, is(haveSameKeys(json2)));
  }

  /**
   * Different keys, different vals
   * 
   * @throws Exception Exception
   */
  @Test
  public void testHaveSameKeys_diff() throws Exception {
    //!>
    String json1 = "{\"menu\": {"+
                     " \"ideee\": \"file\","+
                      "\"value\": \"Fileeeee\","+
                      "\"popup\": {"+
                        "\"menuitem\": ["+
                             "{\"value\": \"Neweee\", \"onclick\": \"CreateNewDoc()\"},"+
                             "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"+
                             "{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"+
                        "]"+
                      "}"+
                   "}}";
    String json2 = "{\"menu\": {"+
            " \"id\": \"file\","+
             "\"value\": \"File\","+
             "\"popup\": {"+
               "\"menuitem\": ["+
                    "{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},"+
                    "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"+
                    "{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"+
               "]"+
             "}"+
          "}}";
    //!<
    assertThat(json1, is(not(haveSameKeys(json2))));
  }

  /**
   * Less keys, different vals
   * 
   * @throws Exception Exception
   */
  @Test
  public void testHaveSameKeys_less() throws Exception {
    //!>
    String json1 = "{\"menu\": {"+
                      "\"value\": \"Fileeeee\","+
                      "\"popup\": {"+
                        "\"menuitem\": ["+
                             "{\"value\": \"Neweee\", \"onclick\": \"CreateNewDoc()\"},"+
                             "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"+
                             "{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"+
                        "]"+
                      "}"+
                   "}}";
    String json2 = "{\"menu\": {"+
            " \"id\": \"file\","+
             "\"value\": \"File\","+
             "\"popup\": {"+
               "\"menuitem\": ["+
                    "{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},"+
                    "{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"+
                    "{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"+
               "]"+
             "}"+
          "}}";
    //!<
    assertThat(json1, is(not(haveSameKeys(json2))));
  }
}
