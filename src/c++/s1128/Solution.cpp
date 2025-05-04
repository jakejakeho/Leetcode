#include <iostream>
#include <unordered_map>
#include <vector>

class Solution {
public:
    int numEquivDominoPairs(std::vector<std::vector<int>>& dominoes) {
        int count = 0;
        std::unordered_map<int, int> countMap;
        for (const auto& d : dominoes) {
            int key = d[0] <= d[1] ? 10 * d[0] + d[1] : 10 * d[1] + d[0];
            int original = countMap[key];
            count += original;
            countMap[key] = original + 1;
        }
        return count;
    }
};


int main() {
    std::cout << "hello world\n";
    Solution *solution = new Solution();
    std::vector<std::vector<int>> dominoes = {
        {1, 2},
        {2, 1},
        {3, 4},
        {5, 6}
    };
    std::cout << solution->numEquivDominoPairs(dominoes) << std::endl;
    return 0;
}
