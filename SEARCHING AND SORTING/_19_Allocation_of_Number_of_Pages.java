public class _19_Allocation_of_Number_of_Pages {
    // Allocate minimum number of pages
    // https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

    /*
     * You have N books, each with A[i] number of pages. M students need to be
     * allocated contiguous books, with each student getting at least one book.
     * Out of all the permutations, the goal is to find the permutation where the
     * sum of maximum number of pages in a book allotted to a student should be
     * minimum, out of all possible permutations.
     */
    public static void main(String args[]) {

        int arr[] = { 13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85 }; // Number of pages in books

        int m = 9; // No. of students

        System.out.println("Minimum number of pages = " + findPages(arr, arr.length, m));

    }

    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M) {
        // If there are more students than books, return -1.
        if (M > N)
            return -1;
        int maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            maxSum += A[i];
        }
        // Perform binary search.
        int start = 0, end = maxSum;
        int mid, ans = -1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (isPossibleSolution(A, N, M, mid)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;

    }

    /*
     * Function to check if it's possible to allocate books such that no student
     * reads more than 'sol' pages.
     */
    static boolean isPossibleSolution(int[] A, int N, int M, int sol) {
        int pageSum = 0, c = 1;
        for (int i = 0; i < N; i++) {
            if (A[i] > sol)
                return false;
            if (pageSum + A[i] > sol) {
                c++;
                pageSum = A[i];
                // If the number of students required exceeds M, return false.
                if (c > M) {
                    return false;
                }
            } else {
                pageSum += A[i];
            }
        }
        return true;
    }

}
