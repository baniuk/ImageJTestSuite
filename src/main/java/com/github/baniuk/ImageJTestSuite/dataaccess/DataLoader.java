package com.github.baniuk.ImageJTestSuite.dataaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Scanner;

import org.scijava.vecmath.Point2d;
import org.slf4j.LoggerFactory;

import com.github.baniuk.ImageJTestSuite.ConvertLists;

import ij.process.FloatPolygon;

/**
 * Minimalistic test data loader.
 * 
 * <p>Load list of points saved as one-column list with interleaving coordinates of vertices:
 * 
 * <pre>
 * x1
 * y1
 * x2
 * y2
 * ...
 * ...
 * xn
 * yn
 * </pre>
 * 
 * <p>The file must contain even number of data. Exemplary code in Matlab to create such file:
 * TODO add example
 * 
 * @author p.baniukiewicz
 *
 */
public class DataLoader {

  /**
   * The Constant LOGGER.
   * 
   * <p><a href="https://stackoverflow.com/questions/14544991/how-to-configure-slf4j-simple">Set
   * level</a>
   */
  static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataLoader.class.getName());
  private List<Double> data;
  /**
   * Data loaded on constructor call.
   */
  public List<Point2d> vert;

  /**
   * Construct dataLoader object.
   * 
   * <p>Open and read datafile
   * 
   * @param fileName file with data (with path)
   * @throws FileNotFoundException on bad file
   * @throws IllegalArgumentException when the number of lines in \c fileName is not power of 2
   */
  public DataLoader(String fileName) throws FileNotFoundException, IllegalArgumentException {
    data = new ArrayList<Double>();
    vert = new ArrayList<Point2d>();
    Scanner scanner = new Scanner(new File(fileName));
    scanner.useLocale(Locale.US);
    while (scanner.hasNextDouble()) {
      data.add(scanner.nextDouble());
    }
    scanner.close();
    convertToPoint2d();
    LOGGER.debug("File: " + fileName + " loaded");
  }

  /**
   * Convert read List/<Double/> to List/<Point2d/>.
   * 
   * @throws IllegalArgumentException on wrong number of data in file
   */
  private void convertToPoint2d() throws IllegalArgumentException {
    if (data.size() % 2 != 0) {
      throw new IllegalArgumentException("Data must be multiply of 2");
    }
    ListIterator<Double> it = data.listIterator();
    while (it.hasNext()) {
      vert.add(new Point2d(it.next().doubleValue(), // x coord
              it.next().doubleValue())); // y coord from input file
    }
  }

  /**
   * Return loaded data.
   * 
   * @return loaded polygon as List/<Point2d/>
   */
  public List<Point2d> getListofPoints() {
    return vert;
  }

  /**
   * Return loaded data as FloatPolygon.
   * 
   * @return Loaded polygon as FloatPolygon
   */
  public FloatPolygon getFloatPolygon() {
    return ConvertLists.fromList2Polygon(getListofPoints());
  }

  /**
   * Convert loaded data to string.
   * 
   * @return String representation of loaded data
   */
  public String toString() {
    return vert.toString();
  }
}