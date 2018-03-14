//https://leetcode.com/problems/find-duplicate-file-in-system/description/



class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,ArrayList<String>> map=new HashMap<>();
        for(String path:paths){
            String []file=path.split(" ");//读取路径跟文件名+文件内容
            String root = file[0];//文件路径
            for(int i=1;i<file.length;i++){
                String []content=file[i].split("[(]");//分离文件名、文件内容
                ArrayList<String> nowContent = map.getOrDefault(content[1], new ArrayList<>());
                nowContent.add(root + "/" + content[0]);
                map.put(content[1], nowContent);//key=内容 value = 文件全路径
            }
        }
        List<List<String>> lls= new ArrayList<>();
        for (ArrayList<String> value : map.values()) {
            if(value.size()>1)
                lls.add(value);
        }  
        return lls;
    }
}
