cmake_minimum_required(VERSION 3.28)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

include_directories (${CMAKE_CURRENT_SOURCE_DIR}/common)

add_executable(cpp
        alg297/main.cpp)