/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        //using dfs stack
        if(root == nullptr) return 0;
        stack<pair<TreeNode*,int>>st;
        int maxi = 0;
        st.push({root,1});
        while(!st.empty())
        {
            auto[te,l]= st.top();
            st.pop();
            maxi = max(maxi,l);
            if(te->left != nullptr) st.push({te->left,l+1});
            if(te->right != nullptr) st.push({te->right,l+1});
        }
        return maxi;

        
    }
};