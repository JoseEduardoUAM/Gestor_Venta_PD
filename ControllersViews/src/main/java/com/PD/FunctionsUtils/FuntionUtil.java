package com.PD.FunctionsUtils;

public class FuntionUtil {

  public static float[] getArrayFloat(String cadena) {
    String[] arrString = cadena.split("\\[|\\]|,");
    float[] arrFloat = new float[arrString.length];
    for (int i = 0; i < arrString.length; i++) {
      if (arrString[i].length() != 0)
        arrFloat[i] = Float.parseFloat(arrString[i]);
      else
        arrFloat[i] = 0;
    }
    return arrFloat;
  }

}
