package com.github.baniuk.ImageJTestSuite.datatoimage;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import org.scijava.vecmath.Point2d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.baniuk.ImageJTestSuite.ConvertLists;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.PolygonRoi;
import ij.gui.Roi;
import ij.process.FloatPolygon;
import ij.process.ImageProcessor;

/**
 * Helper class to export shapes as *.tif images
 * 
 * @author p.baniukiewicz
 *
 */
public class RoiSaver {

  /**
   * The Constant LOGGER.
   */
  static final Logger LOGGER = LoggerFactory.getLogger(RoiSaver.class.getName());

  /**
   * Dummy constructor.
   */
  public RoiSaver() {
  }

  /**
   * Save ROI as image
   * 
   * <p>Get ListArray with vertices and create fileName.tif image with ROI For non-valid input list
   * it creates red image of size 100 x 100
   * 
   * @param fileName file to save image with path
   * @param vert list of vertices
   */
  public static void saveRoi(String fileName, List<Point2d> vert) {
    try {
      Rectangle bb;
      float[] x = new float[vert.size()];
      float[] y = new float[vert.size()];
      int l = 0;
      // copy to arrays
      for (Point2d el : vert) {
        x[l] = (float) el.getX();
        y[l] = (float) el.getY();
        l++;
      }
      bb = getBoundingBox(vert); // get size of image
      bb.grow(20, 20);
      PolygonRoi pp = new PolygonRoi(x, y, Roi.POLYGON); // create polygon object
      LOGGER.debug("Creating image of size [" + bb.width + "," + bb.height + "]");
      ImagePlus outputImage = IJ.createImage("", bb.width, bb.height, 1, 8); // output // margins
      ImageProcessor ip = outputImage.getProcessor(); // get processor required later
      ip.setColor(Color.WHITE); // set pen
      // pp.setLocation(0.1 * bb[0], 0.1 * bb[1]); // move slightly ROI to center
      pp.drawPixels(ip); // draw roi
      IJ.saveAsTiff(outputImage, fileName); // save image
      LOGGER.debug("Saved as: " + fileName);
    } catch (Exception e) { // in any error draw red image
      ImagePlus outputImage = IJ.createImage("", 100, 100, 1, 24);
      ImageProcessor ip = outputImage.getProcessor();
      ip.setColor(Color.RED);
      ip.fill();
      IJ.saveAsTiff(outputImage, fileName); // save image
      LOGGER.error(e.getMessage());
    }

  }

  /**
   * Save ROI as image.
   * 
   * @param fileName fileName
   * @param roi roi
   */
  public static void saveRoi(String fileName, Roi roi) {
    if (roi == null) {
      saveRoi(fileName, (List<Point2d>) null);
      return;
    }
    FloatPolygon fp;
    fp = roi.getFloatPolygon(); // save common part
    saveRoi(fileName, ConvertLists.fromPolygon2List(fp));
  }

  /**
   * Calculates width and height of bounding box for shape defined as List of {@link Point2d}
   * elements.
   * 
   * @param vert List of vertexes of shape
   * @return two elements array where [width height]
   *         TODO use floatpolygon bb instead
   */
  public static Rectangle getBoundingBox(List<Point2d> vert) {
    return ConvertLists.fromList2Polygon(vert).getBounds();
  }
}