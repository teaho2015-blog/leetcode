//
// Created by teaho on 25-2-25.
//

#ifndef CPP_TREENODE_H
#define CPP_TREENODE_H

template<typename T>
struct TreeNode {
    T val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(T val) : val(val), left(nullptr), right(nullptr) {}
};
#endif //CPP_TREENODE_H
