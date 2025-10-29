package string;

public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        while(i<version1.length() || j<version2.length()){
            int k = i;
            int nums1 = 0;
            while(k<version1.length() && version1.charAt(k)!='.'){
                nums1 = nums1*10 + (version1.charAt(k)-'0');
                k++;
            }
            int l = j;
            int nums2 = 0;
            while(l<version2.length() && version2.charAt(l)!='.'){
                nums2 = nums2*10 + (version2.charAt(l)-'0');
                l++;
            }
            if(nums1>nums2){
                return 1;
            }
            else if(nums1<nums2){
                return -1;
            }
            i = k+1;
            j = l+1;

        }
        return 0;
    }
    public static void main(String[] args) {
        String v1 = "1";
        String v2 = "1.1";
        System.out.println(new CompareVersions().compareVersion(v1, v2));
    }

}
