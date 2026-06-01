class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append("#")
            .append(str.length())
            .append("#")
            .append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
        if (str.charAt(i) == '#') {
            i++;

            StringBuilder sizeBuilder = new StringBuilder();

            while (i < str.length() && str.charAt(i) != '#') {
                sizeBuilder.append(str.charAt(i));
                i++;
            }

            int size = Integer.parseInt(sizeBuilder.toString());

            // skip second '#'
            i++;

            result.add(str.substring(i, i + size));

            // move to next encoded string
            i += size;
        }
    }

    return result;
}
}
