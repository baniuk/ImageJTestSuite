package com.github.baniuk.ImageJTestSuite;

import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

import ij.process.ImageProcessor;

/**
 * Static methods that operate on {@link ImageProcessor}
 * 
 * @author p.baniukiewicz
 *
 */
public class ConvertImageProcessors {

  /**
   * Convert ImageProcessor pixel data to array of objects.
   * 
   * @param input ImageProcessor
   * @return array of objects converted from primitives
   */
  public static Number[] castToNumber(ImageProcessor input) {
    Object pixels = input.getPixels();
    if (pixels == null) {
      return null;
    } else if (pixels instanceof byte[]) {
      return ArrayUtils.toObject((byte[]) pixels);
    } else if (pixels instanceof short[]) {
      return ArrayUtils.toObject((short[]) pixels);
    } else if (pixels instanceof int[]) {
      return ArrayUtils.toObject((int[]) pixels);
    } else if (pixels instanceof float[]) {
      return ArrayUtils.toObject((float[]) pixels);
    } else {
      throw new IllegalArgumentException("Unknown bit depth");
    }
  }

  /**
   * Convert 1d double array to Double.
   * 
   * @param input array to convert
   * @return Input array converted to Double
   */
  public static Double[] number2double(Number[] input) {
    final Double[] result = new Double[input.length];
    IntStream.range(0, input.length).forEach(index -> result[index] = input[index].doubleValue());
    return result;
  }
}
