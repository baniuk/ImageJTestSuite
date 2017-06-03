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
   * Convert list of Point2d to FloatPolygon that can be used as 2D array holder.
   * 
   * @param list
   * @return FloatPolygon with x, y
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
   * Convert from FloatPolygon to list of Point2d.
   * 
   * @param polygon
   * @return List of points in unchanged order
   */
  public static List<Point2d> fromPolygon2List(final FloatPolygon polygon) {
    List<Point2d> ret = new ArrayList<Point2d>(polygon.npoints);
    for (int p = 0; p < polygon.npoints; p++) {
      ret.add(new Point2d(polygon.xpoints[p], polygon.ypoints[p]));
    }
    return ret;
  }

}
