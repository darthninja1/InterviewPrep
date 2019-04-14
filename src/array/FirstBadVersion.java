package array;

// https://leetcode.com/problems/first-bad-version
public class FirstBadVersion {
    private int firstBadVersion;

    private FirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public static void main(String[] args) {
        System.out.println(2 == new FirstBadVersion(2).firstBadVersion(3));
        System.out.println(2 == new FirstBadVersion(2).firstBadVersion(10));
        System.out.println(Integer.MAX_VALUE / 2 == new FirstBadVersion(Integer.MAX_VALUE / 2).firstBadVersion(Integer.MAX_VALUE));
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return (version >= firstBadVersion);
    }
}