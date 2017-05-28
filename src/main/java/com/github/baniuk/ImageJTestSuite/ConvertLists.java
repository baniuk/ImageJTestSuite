package com.github.baniuk.ImageJTestSuite;

import java.util.ArrayList;
import java.util.List;

import org.scijava.vecmath.Point2d;

import ij.process.FloatPolygon;

/**
 * Contain static routines for conversions between {@link FloatPolygon} and list of points.
 * 
 * @author p.baniukiewicz
 *
 */
public class ConvertLists {

  /**
   * @param list
   * @return
   */
  public static FloatPolygon fromList2Polygon(final List<Point2d> list) {

    float[] x = new float[list.size()];
    float[] y = new float[list.size()];

    int l = 0;
    for (Point2d p : list) {
      x[l] = (float) p.x;
      y[l] = (float) p.y;
      l++;
    }

    return new FloatPolygon(x, y);
  }

  /**
   * @param polygon
   * @return
   */
  public static List<Point2d> fromPolygon2List(final FloatPolygon polygon) {
    List<Point2d> ret = new ArrayList<Point2d>(polygon.npoints);
    for (int p = 0; p < polygon.npoints; p++) {
      ret.add(new Point2d(polygon.xpoints[p], polygon.ypoints[p]));
    }
    return ret;
  }

}
