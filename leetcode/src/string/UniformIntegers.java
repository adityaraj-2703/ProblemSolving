package string;

public class UniformIntegers {
    public int getUniformIntegerCountInInterval(long A, long B) {
    // Write your code here
    String a = A + "";
    String b = B + "";
    StringBuilder temp = new StringBuilder(a);
    int count=0;
    while(Long.parseLong(temp.toString())<B){
      StringBuilder sb = new StringBuilder();
      int t = temp.charAt(0)-'0';
      for(int i=t;i<=9;i++){
        for(int j=0;j<temp.length();j++){
          sb.append(i);
        }
        if(Long.parseLong(sb.toString())<=B){
          count++;
        }
        sb = new StringBuilder();
      }
      temp.append('0');
      temp.setCharAt(0, '1');
    }
    return count;
  }

  public static void main(String[] args) {
    long a = 1;
    long b = 9;
    UniformIntegers u = new UniformIntegers();
    System.out.println(u.getUniformIntegerCountInInterval(a, b));
  }
}
