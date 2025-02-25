//
// Created by teaho on 25-2-25.
//

#ifndef CPP_TREENODE_H
#define CPP_TREENODE_H

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};
#endif //CPP_TREENODE_H
