public class Solution {
    public double findMedianSortedArrays(int a[], int b[]) {
        int lena = a.length;
        int lenb = b.length;
        
        if (((lena + lenb) & 0x1) == 0)
            return (findKth(a, 0, lena - 1, b, 0, lenb - 1, (lena + lenb) / 2) +
                   findKth(a, 0, lena - 1, b, 0, lenb - 1, (lena + lenb) / 2 + 1)) / 2.0;
        else
            return findKth(a, 0, lena - 1, b, 0, lenb - 1, (lena + lenb) / 2 + 1) * 1.0;
    }
    
    private int findKth(int[] a, int heada, int taila, int[] b, int headb, int tailb, int k) {
        if (taila - heada > tailb - headb)
            return findKth(b, headb, tailb, a, heada, taila, k);
        
        if (heada > taila)
            return b[headb + k - 1];
        if (k == 1)
            return Math.min(a[heada], b[headb]);
        
        int pa = Math.min(k / 2, taila - heada + 1), pb = k - pa;
        if (a[heada + pa - 1] < b[headb + pb - 1])
            return findKth(a, heada + pa, taila, b, headb, tailb, k - pa);
        else if (a[heada + pa - 1] > b[headb + pb - 1])
            return findKth(a, heada, taila, b, headb + pb, tailb, k - pb);
        else 
            return a[heada + pa - 1];
    }
}