package shasha.company.Strings;

public class Powerof2 {
    public static void main(String[] args) {
        System.out.println(powerSecond("6"));
    }
    private static int power(String s) {
        int num=0;
        if(s.length()==1){
            num = Integer.parseInt(s);
            if(num==1 || num == 2|| num== 4|| num == 8)
                return 1;
            else
                return 0;
        }
        while(s.length()>1){
            if((s.charAt(s.length()-1)-'0')%2==1)
                return 0;
            else
            {
                StringBuilder sr = new StringBuilder();
                int i=0,div=0,dividend=0;
                while(i<s.length()){
                    dividend = dividend *10 +(s.charAt(i)-'0');
                    if(dividend==0){
                        sr.append(0);
                        i++;
                        continue;
                    }
                    num = dividend/2;
                    dividend = dividend%2;
                    sr.append((char) (num+'0'));  //append takes character and if we pass without braces it will append two values.
                    i++;
                }
                while(sr.charAt(0)=='0')
                    sr.deleteCharAt(0);
                s= sr.toString();
            }
        }
        if(s.length()==1){
            num = Integer.parseInt(s);
            if(num%2==0|| num == 2|| num== 4|| num == 8)
                return 1;
            else
                return 0;
        }
        return 0;
    }

    private static int powerSecond(String a){
        if(a==null)
            return 0;
        char arr[] = a.toCharArray();

        //System.out.println(arr);
        int arrStart=0;
        int arrEnd=arr.length-1;

        while(arrStart<arrEnd)
        {

            if(((int)arr[arrEnd]-48)%2!=0)
                return 0;
            for(int i=arrStart, carryOver=0;i<=arrEnd;i++)
            {
                int currElement = (int)arr[i]-48;
                currElement=10*carryOver+currElement;

                if(currElement<2)
                {
                    arr[i]=48;
                    carryOver=currElement;
                }

                else
                {
                    arr[i]=(char)(48 + currElement/2);
                    carryOver=currElement%2;
                }
                //System.out.println(arr);
            }

            if(arr[arrStart]==48)
                arrStart++;
        }
        if(((int)arr[arrEnd]-48)%2==0)
            return 1;
        return 0;
    }
}
