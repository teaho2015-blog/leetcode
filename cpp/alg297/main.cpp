#include <iostream>
#include <thread>
#include "../common/IntTreeNode.h"

using std::cout;
using std::endl;
using std::string;
using std::to_string;


//
// Created by teaho on 25-2-25.
//
class Codec {
public:
    void rser(TreeNode* root, string& s) {
        if (root == nullptr) {
            s += "N,";
            return;
        }
        s += to_string(root->val) + ",";
        rser(root->left, s);
        rser(root->right, s);

    }

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string s;
        rser(root, s);
        return s;
    }

    TreeNode* rdeser(int &cur, const string& data) {
        if (data[cur] == 'N') {
            cur = cur + 2;
            return NULL;
        }

        int nxt = data.find(',', cur);
        int val = stoi(data.substr(cur, nxt - cur));

        TreeNode *r = new TreeNode(val);
        cur = nxt + 1;

        r->left = rdeser(cur, data);
        r->right = rdeser(cur, data);

        return r;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        int cur = 0;
        return rdeser(cur, data);
    }
};


int main()
{
    Codec ser, deser;
    TreeNode* root = new TreeNode(1);
    TreeNode* left = new TreeNode(2);
    TreeNode* right = new TreeNode(3);
    root->left = left;
    root->right = right;
    TreeNode* result = deser.deserialize(ser.serialize(root));
    std::cout << "result:" << result << std::endl;


}