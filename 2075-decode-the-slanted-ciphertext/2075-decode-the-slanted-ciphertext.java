class Solution {
    public String decodeCiphertext(String eT, int rows) {
        if(eT.length()==0)return "";
        int yLimit = eT.length() / rows;
        char[][] mat = new char[rows][eT.length() / rows];
        int x = 0;
        int y = 0;
        for (char a : eT.toCharArray()) {
            if (y >= yLimit) {
                y = 0;
                x++;
            }
            mat[x][y] = a;
            y++; 
        }
        StringBuilder sb=new StringBuilder();
       
        int yadition=0;
        while(true){
            x=0;
            y=0+yadition;
            boolean check=false;
            for(int a=0;a<rows;a++){
                if(x>=mat.length||y>=mat[0].length){
                    if(a==0){
                    check=true;

                    }
                    break;
                }
                sb.append(mat[x][y]);
                x++;
                y++;
            }
            if(check){
                break;
            }
            yadition++;
        }
        int a=0;
        for(a=sb.length()-1;a>=0;a--){
            if(sb.charAt(a)!=' '){
               break; 
            }
        }
        return sb.substring(0,a+1); 

    }
}