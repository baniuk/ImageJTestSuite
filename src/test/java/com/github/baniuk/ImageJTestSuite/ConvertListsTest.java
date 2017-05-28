package com.github.baniuk.ImageJTestSuite;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.scijava.vecmath.Point2d;

import com.github.baniuk.ImageJTestSuite.ConvertLists;

import ij.process.FloatPolygon;

/**
 * @author p.baniukiewicz
 *
 */
public class ConvertListsTest {

  /**
   * Test method for
   * {@link com.github.baniuk.ImageJTestSuite.ConvertLists#fromList2Polygon(java.util.List)}.
   * 
   * @throws Exception
   */
  @Test
  public void testFromList2Polygon() throws Exception {
    // empty list
    List<Point2d> test = new ArrayList<>();
    FloatPolygon ret = ConvertLists.fromList2Polygon(test);
    assertThat(ret.npoints, is(0)); // empty polygon

    // not empty list, check order
    test.clear();
    test.add(new Point2d(0, 0));
    test.add(new Point2d(5, 4));
    ret = ConvertLists.fromList2Polygon(test);
    assertThat(ret.npoints, is(2));
    assertThat(ret.xpoints[1], is(5f));
    assertThat(ret.ypoints[1], is(4f));
  }

  /**
   * Test method for
   * {@link com.github.baniuk.ImageJTestSuite.ConvertLists#fromPolygon2List(ij.process.FloatPolygon)}.
   * 
   * @throws Exception
   */
  @Test
  public void testFromPolygon2List() throws Exception {
    FloatPolygon p = new FloatPolygon(); // empty polygon
    List<Point2d> ret = ConvertLists.fromPolygon2List(p);
    assertThat(ret.isEmpty(), is(true)); // empty list on return

    // not empty polygon, check order
    float[] x = { 0f, 5f };
    float[] y = { 0f, 4f };
    p = new FloatPolygon(x, y);
    ret = ConvertLists.fromPolygon2List(p);
    assertThat(ret.size(), is(2));
    assertThat(ret.get(1).x, is(5.0));
    assertThat(ret.get(1).y, is(4.0));
  }

}
