#include <iostream>
#include <thread>
#include "../common/IntTreeNode.h"

using std::cout;
using std::endl;
using std::string;
using std::to_string;



/*
647. 回文子串
https://leetcode.cn/problems/palindromic-substrings/description/?envType=problem-list-v2&envId=2cktkvj&

中心拓展：枚举每个可能的子串中心，并向两边拓展

时间复杂度：O(n^2)
空间复杂度：O(1)

Created by teaho on 25-03-12
*/
class Solution {
public:
    int countSubstrings(string s) {
        int n = s.size(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i/2, r = i/2 + i %2;
            while(l>=0 && r < n && s[l] == s[r]) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
};

int main()
{

    Solution s;
    int result = s.countSubstrings("abc");

    std::cout << "result:" << result << std::endl;


}