package xcoding.other;

import java.util.*;

public class SubstringsCount {

    public static void main(String[] args){
        long i = substringCalculator("ghaqjdrmnegmrlrlfpjmnnngpwalzknsencuzwsnhfltwohdgbmvfuwtquosrnyerucntxxkfqehjqygcarxogvcfkljzbzutxphpyykapncjfclnhndzxghelyvzpylazhuutmcquusexzbhsfsmbnlvnlemzvfqbfzwquairhpylnbvyhiyamztlhfchhbwrqddmuzsprfdwuqqchcpeakkexackwwzihkfenwzwckynymgqydvjtovaoezkjjurylqcuonsujycziobnfnmuwnoxcdtahpituykvgpyyshvukrstcbmnsqtjseflwywnslmvnqrtnzkyaddkjamrezprqgoenzsdryygbkeahfiduozpwkrgmatszaxmwodsqiocvagbvxyqotpaujnqvqgjmfxnxhfbwqjpgodlxdrxpjpmzeabpgqrzpxomniknjkdiwtfgyvwvekrnoupwkcbtmpcfamzrghgrznuedkybmfwctdghcfawajlxfkzhdamuygjbcwnyglkjlfmpxfdtovkqbshhrfrnyjrgxgiozsuuncnwofkqzsypwgeikpfbhryhpszegdfajzvqlwwqlnvdtdiuckcvvosrdweohnmawqonjbxyjjhlccuteeshfrxxdhzgakwjqbymnaeudcmibsytyajsgdpfvrutcpglzxdevenevmkgalcrpknuvcrnkuboennhyzirfwvtozzijujsckbxqpocakzrbwgpqgjjmsrtwmvhwyraukbuxfvebeylfpipzwjdzlmgslbtwzataxgqpasrssnfwndldwkdutdqcmcpyanrbdsxrvcvpsywjambtbzlcrvzesuhvyvwwuwwdznigxjxknfajpknqutfvvqynkpvkzgypasevrpxofbymdzcitoqolwqegocuyqsexhumzmckzuuwkamolbltlifongpvkcnrnnuplftqbxpdnegdqlymftqyrxcnzmu");
        System.out.println(i);
    }

    public static long substringCalculator(String s) {
        // Write your code here
        int sum = 0;
        int n = s.length();
        if(n > 2){
            int x = n;
            while(x>0){
                sum = sum + (2*x-1);
                x = x-2;
            }
        }else{
            sum = 3;
        }
        Map<Character, List<Integer>> posMap = new HashMap<Character, List<Integer>>();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(posMap.containsKey(c)){
                --sum;
                for(int y : posMap.get(c)){
                    y++;
                    int x = i+1;
                    while(x<n && y<n){
                        if(s.charAt(x) == s.charAt(y)){
                            --sum;
                            x++;
                            y++;
                        }else{
                            break;
                        }
                    }
                }
                posMap.get(c).add(i);
            }else{
                List<Integer> pos = new LinkedList<>();
                pos.add(i);
                posMap.put(c, pos);
            }
        }
        return sum;

    }



}
