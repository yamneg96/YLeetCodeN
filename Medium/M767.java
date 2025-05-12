public class M767 {
  
  public String reorganizeString(String s){
    int totlen = s.length();
    StringBuilder res = new StringBuilder(s);
    StringBuilder result = new StringBuilder(s);
    for(int i=1; i<=totlen; i++){
      if(res.charAt(i--) != (res.charAt(++i))){
        result.delete(0, totlen-1);
        result.append(res.charAt(i));
      }
      else{
        res.deleteCharAt(i);
      }
    }
    return result.toString();
  }
  public static void main(String[] args) {
    System.out.println(new M767().reorganizeString("aab"));
    System.out.println(new M767().reorganizeString("aaab"));
    System.out.println(new M767().reorganizeString("aabbcc"));
  }
}