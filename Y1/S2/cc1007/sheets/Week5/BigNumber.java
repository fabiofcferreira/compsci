public class BigNumber {
  private int[] number = new int[1000];
  
  BigNumber(String n) {
    for (int i = 0; i < 1000 - n.length(); i++) {
      number[i] = 0;
    }

    // create array of integers for each one of the digits in the string
    for (int i = 0; i < n.length(); i++) {
      number[1000 - n.length() + i] = Integer.parseInt(String.valueOf(n.charAt(i)));
    }
  }

  public boolean equals(BigNumber n) {
    int[] n2 = new int[1000];

    // copy all digits from string
    for (int i = 0; i < n.toString().length(); i++) {
      n2[1000 - n.toString().length() + i] = Integer.parseInt(String.valueOf(n.toString().charAt(i)));
    }

    for (int i = 0; i < 1000; i++) {
      if (number[i] != n2[i]) {
        return false;
      }
    }

    return true;
  }
  
  public String toString() {
    boolean numberStarted = false;
    String numberStr = "";

    for (int i = 0; i < 1000; i++) {
      if (number[i] != 0) {
        numberStarted = true;
      }

      if (numberStarted) {
        numberStr += number[i];
      }
    }

    return numberStr;
  }

  public BigNumber add(BigNumber n) {
    int[] n2 = new int[1000];
    int[] nresult = new int[1000];

    // copy added number to an array of integers for each one
    // of the digits in the string
    for (int i = 0; i < n.toString().length(); i++) {
      n2[1000 - n.toString().length() + i] = Integer.parseInt(String.valueOf(n.toString().charAt(i)));
    }

    int carry = 0;
    for (int i = 999; i >= 0; i--) {
      int addResult = number[i] + n2[i] + carry;

      if (addResult >= 10) {
        if (carry > 1) {
          addResult %= (carry * 10);
        } else {
          addResult %= 10;
        }

        carry = 1;
      } else {
        carry = 0;
      }

      nresult[i] = addResult;
    }

    // copy result number to string
    boolean numberStarted = false;
    String resultStr = "";

    for (int i = 0; i < 1000; i++) {
      if (nresult[i] != 0) {
        numberStarted = true;
      }

      if (numberStarted) {
        resultStr += nresult[i];
      }
    }

    return new BigNumber(resultStr);
  }
  
  public BigNumber multiply(BigNumber n) {
    int[] n2 = new int[1000];
    int[] nresult = new int[1000];
    int fOperandSize = 0;
    int sOperandSize = n.toString().length();

    // calculate operand size
    for (int i = 0; i < 1000; i++) {
      if (number[i] != 0) {
        fOperandSize = 1000 - i;
        break;
      }
    }

    // copy added number
    // create array of integers for each one of the digits in the string
    for (int i = 0; i < sOperandSize; i++) {
      n2[1000 - sOperandSize + i] = Integer.parseInt(String.valueOf(n.toString().charAt(i)));
    }

    // int carry = 0;
    for (int i = 999; i > 999 - sOperandSize; i--) {
      // multiply second operand digit with each one of the first operand digits
      for (int j = 999; j > 999 - fOperandSize; j--) {
        int productResult = n2[i] * number[j];
        int decimal = productResult / 10;
        int remainder = 0;
        int arrayPos = j - (999 - i);
        
        // add product result to the result array
        if (decimal > 0) nresult[arrayPos] += productResult % 10;
        else nresult[arrayPos] += decimal;

        // add carry to the digit before
        if (arrayPos >= 1) nresult[arrayPos - 1] += decimal;

        // carry calculation
        for (int a = arrayPos; a >= 0; a--) {
          if (nresult[a] >= 10) {
            int carry = nresult[a] / 10;
            int r = nresult[a] % 10;
  
            nresult[a] = r;
            nresult[a - 1] += carry;
          }
        }
      }
    }

    // copy result number to string
    boolean numberStarted = false;
    String resultStr = "";

    for (int i = 0; i < 1000; i++) {
      if (nresult[i] != 0) {
        numberStarted = true;
      }

      if (numberStarted) {
        resultStr += nresult[i];
      }
    }

    return new BigNumber(resultStr);
  }
}