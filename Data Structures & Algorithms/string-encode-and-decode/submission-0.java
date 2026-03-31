class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs){
            builder.append(str.length());
            builder.append("#");
            builder.append(str);
        }
        return builder.toString();

    }

    public List<String> decode(String str) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            j++;
            res.add(str.substring(j,j+length));
            i = j+length;
        }
        return res;

    }
}
