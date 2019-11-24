package 周赛164;
import java.util.*;

public class Solution_1267 {
    /**
     * 自己的办法，还没修改好
     * 想法：把searchWord拆分成n个字符，每次遍历products中每一个的对应位置
     * 比如说
     * products = ["mobile","mouse","moneypot","monitor","mousepad"]
     * searchWord = "mouse"
     * 排序后，先查找products中第一个字母是m的，然后是第二个字母是o的，以此类推
     * @param products
     * @param searchWord
     * @return
     */
//    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        List<List<String>> list = new ArrayList<>();
//        boolean[] bo = new boolean[products.length];
//        for (int i = 0; i < products.length; i++) {
//            bo[i] = true;
//        }
//        arraySort(products);
//        for (int i = 0; i < searchWord.length(); i++) {
//            char s = searchWord.charAt(i);
//            List<String> s_list = new ArrayList<>();
//            int num = 0;
//            for (int j = 0; j < products.length && i < products[j].length(); j++) {
//             if (bo[j] && products[j].charAt(i) == s) {
//                 if (num < 3)
//                    s_list.add(products[j]);
//                 num++;
//             } else {
//                 bo[j] = false;
//             }
//            }
//            list.add(s_list);
//        }
//        return list;
//    }
//
//    public static String[] arraySort(String[] input) {
//        for (int i = 0; i < input.length - 1; i++) {
//            for (int j = 0; j < input.length - i - 1; j++) {
//                if (input[j].compareTo(input[j + 1]) > 0) {
//                    String temp = input[j];
//                    input[j] = input[j + 1];
//                    input[j + 1] = temp;
//                }
//            }
//        }
//        return input;
//    }

    /**
     * 1.采用优先队列存储products（排序）
     * 2.按位比较优先队列和searchWord,直到某一个到结尾
     *  删除优先队列中和searchWord不匹配的项
     * 3.输出前三个
     * @param products
     * @param searchWord
     * @return
     */
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < products.length; i++) {
            queue.offer(products[i]);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            Iterator<String> iter = queue.iterator();
            while (iter.hasNext()) {
                String product = iter.next();
                if (i < product.length() && product.charAt(i) == c) {
                } else {
                    iter.remove();
                }
            }
            int count = 0;
            List<String> tmp = new ArrayList<>();
            while (!queue.isEmpty() && count++ < 3) {
                tmp.add(queue.poll());
            }
            queue.addAll(tmp);
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
//        example 1
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
//        example 2
//        String[] products = {"havana"};
//        String searchWord = "havana";
//        example 3
//        String[] products = {"havana"};
//        String searchWord = "tatiana";
//        example 4
//        String[] products = {"kfnwqytfhroyewirkaofdwdjtzyaeamrqkbdzganjfqfykfwizgtxjhrbvnmbwyfivwrbbjralxuptonwhlvztgefnggltqekduxdhznowjsayyaieacjvewhfookivjuwmwmhlobrgummkvjwclbipmkwrpbwqlbthbokenmcaupqbtuglgqtpuognhfachuscdsztjbuffgdzajlzhmnmksdnyrhahnnhilwnqohxyjsiatzshinquevymllusyqzkjwovmgtwwfztpbcpvyjdkqcdkscpimchxdjdrxvropgbgrrccfqnatlqjlojfczeggnanpuqtebjcyezdqpxsfkegxqfeplcmfxyqmlruapeywuftbbosmpegfpcepukcsvpgmfundbvbzazwqnefmbnnxntixtormwfbnuwheahzddwksodogedymeujvxacdbguthxhlcmmblfwjrnurpfuawoghyakqkccxcgxzdraasdivjgvtjrulhgktdxjuzpdyewckrpmjrttusqubhwntpchscprcdddsbyxrqrnplgazwjvojrtxogqdvqarcspvkfljlswpktqxlndidtnhzryohyyujfncunynxkblsdpjlaifdzsjxpuapwjzwzeahrnfkgtaehwjqsligfjnmsivinygzoeaejagsvzkyicbsyfxhqaotexdsvtxuexnmqsjhmojexevbgozlkbmuuexgpklnsetscrceuvtfhrxwvloiucqbzpxwtodopesljmisfxqmxhjlehpyaodfwqbnfvjtplauiyiyrddbjdpkvznmvpbzxgemfhgpwligjwznbztyaenziwooceebfwppfpgmzczoenqtmqcjdgvdlhjpwwlqcyjmaqnjicyrocrvxxrnrhpsqvrndurviilufvwbsswtjlmefydjechqrgeqjucsjyaaudocxgpvtbfekgynmnywltxvqddtjdaunvfqjclrjsohfenjxqjpvcklfdjoaavgoukzqjijycwqipkzpcvaqzqwgwnolrqudrcqqymlhelskpvrlobsjxlgsunkdlvqdgpnnrhcgdxasbdmrcrauswiticdiwkhdvpkduqgqpujcyjkrksmhjswvqccpxfacszfdsdvoxjnlphqawjlxryprgoexjqxryuxadviwdebxjyzolpqerfkxhklgpeffahclnfyfnwudwnjjqbcazsuzekwfsprbiwztqsxtxpiemfucwgcamdowvoymuwkstyqggmtknzezacoklmiaanvsttqknedeoayakomzzzntfmyfaunsnvimvkboqcfprizsofhauflvmetrwfoigjcxjavspnaqwpagfwslxolbjgglknrcacqntfcizfkmcrdbdidvojdritvnvgnsvrhjcutojfvjaspzdodnisyuirklwcxjitakdpxaclthbxgooxmqslftctxopfencxtzktckpkpkhlkboueylshbztlvkbtkpjdcxakldxmnjnqjyscgvydlmnpfnaxaicylivtesvtoqimovynmntiijxnwinlirbmiubpwlmwdscynsywgswsklxaxjwoculminicuphgtepjxmlhaolzzxuqqawjmvlniknniwexrelrvxagbtcqnzhdmiqfkyvwnsfuzskzlcvcyluzjtesuvzdknipreueyqgzvgbeqtmcnzwtfdgmihuzwtsdxahawfiwnpzzwpnzawfzyobyriuxbnlojvkfycwprgngluhgyirhutknuvdyebwrmaarbelkhzoqpilrneitzzuysmlpczdepdngeuwcpylcysafnmzulcrzlkaskbiexjikebbrwlbcpgvmiumsafuzqcuxnpwtjgqmlmnbeauljmyrxykugovjfazsrkzsyonecfejokeiwtxvdjawbkgvlqegxcoxwhldzoblzvhydopqpatwxllccdnlmxjypjiimtczqhubuloozyiwjmcsooqvufuamaopwxsexaaohazzctezrqahkdsnkqspkjqcvocnqirwzxocbxibrwrlrhzcuxlfqsgwoqyagkmcrdedasvrzjgugbrvvbsjtmjfbdxhchbkfomefrfrwdiyhhskrqstnnwrclsphqfrbwjvlitjmwtlmx","kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoenmjzunulkrjyxfugrpvkwoiwyxwgrweakhbswllbyziranhxkleggegegdailjgyteaghdqnjqdjfhyrapqmckvxgxmasnweej","kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyrxokhdtynjgygqarnhyaqsdrgdqdmpfwdhlayltvrjalfxxctwgqtmuwgdwzxyuiictaul","oqjrtcokaagakchrwrdbrlpnqivwcpzwuxbdkpkhndevouwyrtmbokxolhbvrencthmyplqixnhnokbhtbstmslfbinsypubqjckiqujvmknxuomdwqkfudgiqmpzkvnshrmnoeonzyfaipdcfdwhekrazfkdlfluyvoevahsyhvqjfcizxjhucbpqdjgmqqalqnvfyrtfkyrxlavfbagxkdloetaiedqbrmtzxwwrpyewrcbntsnrdzurzlfokcxolkltouozdobqvtoldjuincumspqpujynxxetbflfnkrscxgrvennmczurjvnoalxcfcrnddfckavedjrvewmawxazviumzpudgolofsxllhgsdrnvjbipcsqsdoosfdkhavhicsfbyavwyxziefmycknhzqujqkbqhacuaebwqpkfnkovxchczohhirczixikuoktkaamchcghynclonujiyzkcghjjjtzckjxmpssfqjirnfvrddvoqvdeteegupzevydcywjsoybsflpgpzkcoztcayffscwxkofwibguysdjtmddgevjhbxrfiqliqyiczdunhosdctrvlagcugpsskpvlsdhcbpdtdwjbhchymlptjrmzmezwljxemgzecptluxbwtgoyvqwrvxkartgrebdegyqdibemnficwpgsywlzczvwujmykkyhkkxhvrtmjxcyidawfxjcagsgutndplixpepddiosflfoujxndtgxsbzarlwacjtydorlrtukbyibaktiphojmrcbwjppnuwwihuerqswjpmyblrdslnwpdnzovpslsrfbzhjywbimwdiqhxmdssjovufgbqqykozfjbylihfwanzjdtgeoimwowocykeskvivwuybdrowolstbrbenioagkgwednhymqisdvjuycjvtrurzqssxrisozysizxeoyelhglnppsjzggjunmyabzptlfktzphlmhvpoqlnrwgxauepumssyecjpwfozhxhvodsasomhtgbasijrpphbijnxcyrajypogighdxacjxqyxagfuenwrdajqsuzrjtrqjebjnbmdzbqdgmbuqofbyegnxvgsegbaqxsdjjffdxiqgqtlgclqtmjqfmbrsccnoidkugbwscamrqfqmpbfuvvoxrodoccusixfehzetsbiflonazsmacvwilarpgpwjkexykqkmklqcuhdrhhgrzofbsjvzwdaghqxajgwqmuhyyervscyiyggbqyhpvotnmaubapigegatgtqeazgcytubsuhjzipbyxnkyqveeetgecxwinwdjuawpzdieizlzqplzajafeernecfkpiilnuqdjnipjybqishinomemdxfwabhemxecuyailbogehxwwtzvaueonxkjmdvojpjjxaftvnbbsfcjjyzwartrbmxgktbhrqeynwoziddoh"};
//        String searchWord = "jhljdwmzajzhbzlnuvnzlypvdwelzenkmuekbfhhwrfgltwxtytyeifurnnvdjyzwzsqyprcqxatrfvfabwoeoybqfbtkgicltqtkzgdvpwsnzvvhgelwqqtdruknthfmpgekmnsnxbjtgkorweyotixwlcwyvjhsgjmcxkthszqffcuanggmjxvzykcfajvlbromoiaabgtihdkyxrfdlofvhsbdjlbyktpawxdwqgwlaxqjzdvvvvrksuhfuyjimkuiptxbkehzvgefavleaegbopivdhzpzhgehjorevmxvzivdigmldsrgtlptdorekere";
//        example 5
//        String[] products = {"kfnwqytfhroyewirkaofdwdjtzyaeamrqkbdzganjfqfykfwizgtxjhrbvnmbwyfivwrbbjralxuptonwhlvztgefnggltqekduxdhznowjsayyaieacjvewhfookivjuwmwmhlobrgummkvjwclbipmkwrpbwqlbthbokenmcaupqbtuglgqtpuognhfachuscdsztjbuffgdzajlzhmnmksdnyrhahnnhilwnqohxyjsiatzshinquevymllusyqzkjwovmgtwwfztpbcpvyjdkqcdkscpimchxdjdrxvropgbgrrccfqnatlqjlojfczeggnanpuqtebjcyezdqpxsfkegxqfeplcmfxyqmlruapeywuftbbosmpegfpcepukcsvpgmfundbvbzazwqnefmbnnxntixtormwfbnuwheahzddwksodogedymeujvxacdbguthxhlcmmblfwjrnurpfuawoghyakqkccxcgxzdraasdivjgvtjrulhgktdxjuzpdyewckrpmjrttusqubhwntpchscprcdddsbyxrqrnplgazwjvojrtxogqdvqarcspvkfljlswpktqxlndidtnhzryohyyujfncunynxkblsdpjlaifdzsjxpuapwjzwzeahrnfkgtaehwjqsligfjnmsivinygzoeaejagsvzkyicbsyfxhqaotexdsvtxuexnmqsjhmojexevbgozlkbmuuexgpklnsetscrceuvtfhrxwvloiucqbzpxwtodopesljmisfxqmxhjlehpyaodfwqbnfvjtplauiyiyrddbjdpkvznmvpbzxgemfhgpwligjwznbztyaenziwooceebfwppfpgmzczoenqtmqcjdgvdlhjpwwlqcyjmaqnjicyrocrvxxrnrhpsqvrndurviilufvwbsswtjlmefydjechqrgeqjucsjyaaudocxgpvtbfekgynmnywltxvqddtjdaunvfqjclrjsohfenjxqjpvcklfdjoaavgoukzqjijycwqipkzpcvaqzqwgwnolrqudrcqqymlhelskpvrlobsjxlgsunkdlvqdgpnnrhcgdxasbdmrcrauswiticdiwkhdvpkduqgqpujcyjkrksmhjswvqccpxfacszfdsdvoxjnlphqawjlxryprgoexjqxryuxadviwdebxjyzolpqerfkxhklgpeffahclnfyfnwudwnjjqbcazsuzekwfsprbiwztqsxtxpiemfucwgcamdowvoymuwkstyqggmtknzezacoklmiaanvsttqknedeoayakomzzzntfmyfaunsnvimvkboqcfprizsofhauflvmetrwfoigjcxjavspnaqwpagfwslxolbjgglknrcacqntfcizfkmcrdbdidvojdritvnvgnsvrhjcutojfvjaspzdodnisyuirklwcxjitakdpxaclthbxgooxmqslftctxopfencxtzktckpkpkhlkboueylshbztlvkbtkpjdcxakldxmnjnqjyscgvydlmnpfnaxaicylivtesvtoqimovynmntiijxnwinlirbmiubpwlmwdscynsywgswsklxaxjwoculminicuphgtepjxmlhaolzzxuqqawjmvlniknniwexrelrvxagbtcqnzhdmiqfkyvwnsfuzskzlcvcyluzjtesuvzdknipreueyqgzvgbeqtmcnzwtfdgmihuzwtsdxahawfiwnpzzwpnzawfzyobyriuxbnlojvkfycwprgngluhgyirhutknuvdyebwrmaarbelkhzoqpilrneitzzuysmlpczdepdngeuwcpylcysafnmzulcrzlkaskbiexjikebbrwlbcpgvmiumsafuzqcuxnpwtjgqmlmnbeauljmyrxykugovjfazsrkzsyonecfejokeiwtxvdjawbkgvlqegxcoxwhldzoblzvhydopqpatwxllccdnlmxjypjiimtczqhubuloozyiwjmcsooqvufuamaopwxsexaaohazzctezrqahkdsnkqspkjqcvocnqirwzxocbxibrwrlrhzcuxlfqsgwoqyagkmcrdedasvrzjgugbrvvbsjtmjfbdxhchbkfomefrfrwdiyhhskrqstnnwrclsphqfrbwjvlitjmwtlmx","kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoenmjzunulkrjyxfugrpvkwoiwyxwgrweakhbswllbyziranhxkleggegegdailjgyteaghdqnjqdjfhyrapqmckvxgxmasnweej","kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyrxokhdtynjgygqarnhyaqsdrgdqdmpfwdhlayltvrjalfxxctwgqtmuwgdwzxyuiictaul","oqjrtcokaagakchrwrdbrlpnqivwcpzwuxbdkpkhndevouwyrtmbokxolhbvrencthmyplqixnhnokbhtbstmslfbinsypubqjckiqujvmknxuomdwqkfudgiqmpzkvnshrmnoeonzyfaipdcfdwhekrazfkdlfluyvoevahsyhvqjfcizxjhucbpqdjgmqqalqnvfyrtfkyrxlavfbagxkdloetaiedqbrmtzxwwrpyewrcbntsnrdzurzlfokcxolkltouozdobqvtoldjuincumspqpujynxxetbflfnkrscxgrvennmczurjvnoalxcfcrnddfckavedjrvewmawxazviumzpudgolofsxllhgsdrnvjbipcsqsdoosfdkhavhicsfbyavwyxziefmycknhzqujqkbqhacuaebwqpkfnkovxchczohhirczixikuoktkaamchcghynclonujiyzkcghjjjtzckjxmpssfqjirnfvrddvoqvdeteegupzevydcywjsoybsflpgpzkcoztcayffscwxkofwibguysdjtmddgevjhbxrfiqliqyiczdunhosdctrvlagcugpsskpvlsdhcbpdtdwjbhchymlptjrmzmezwljxemgzecptluxbwtgoyvqwrvxkartgrebdegyqdibemnficwpgsywlzczvwujmykkyhkkxhvrtmjxcyidawfxjcagsgutndplixpepddiosflfoujxndtgxsbzarlwacjtydorlrtukbyibaktiphojmrcbwjppnuwwihuerqswjpmyblrdslnwpdnzovpslsrfbzhjywbimwdiqhxmdssjovufgbqqykozfjbylihfwanzjdtgeoimwowocykeskvivwuybdrowolstbrbenioagkgwednhymqisdvjuycjvtrurzqssxrisozysizxeoyelhglnppsjzggjunmyabzptlfktzphlmhvpoqlnrwgxauepumssyecjpwfozhxhvodsasomhtgbasijrpphbijnxcyrajypogighdxacjxqyxagfuenwrdajqsuzrjtrqjebjnbmdzbqdgmbuqofbyegnxvgsegbaqxsdjjffdxiqgqtlgclqtmjqfmbrsccnoidkugbwscamrqfqmpbfuvvoxrodoccusixfehzetsbiflonazsmacvwilarpgpwjkexykqkmklqcuhdrhhgrzofbsjvzwdaghqxajgwqmuhyyervscyiyggbqyhpvotnmaubapigegatgtqeazgcytubsuhjzipbyxnkyqveeetgecxwinwdjuawpzdieizlzqplzajafeernecfkpiilnuqdjnipjybqishinomemdxfwabhemxecuyailbogehxwwtzvaueonxkjmdvojpjjxaftvnbbsfcjjyzwartrbmxgktbhrqeynwoziddoh"};
//        String searchWord = "kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoyrnqunojmtporeofgldjntqvlngobvtpbhmmdrkosxlkvmivonldjr";
        System.out.println(suggestedProducts(products, searchWord));


    }
    /*

     */
}
