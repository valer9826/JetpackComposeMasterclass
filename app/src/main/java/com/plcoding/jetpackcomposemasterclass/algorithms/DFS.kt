package com.plcoding.jetpackcomposemasterclass.algorithms

import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'roadsAndLibraries' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER c_lib
 *  3. INTEGER c_road
 *  4. 2D_INTEGER_ARRAY cities
 */

fun roadsAndLibraries(
    citiesNumber: Int,
    libraryCost: Int,
    roadCost: Int,
    cities: Array<Array<Int>>
): Long {
    if (libraryCost <= roadCost) return citiesNumber.toLong() * libraryCost

    val graph = Array(citiesNumber + 1) { mutableListOf<Int>() }
    for (city in cities) {
        val u = city[0]
        val v = city[1]
        graph[u].add(v)
        graph[v].add(u)
    }

    val citiesVisited = BooleanArray(citiesNumber + 1)

    fun dfs(node: Int): Int {
        val stack: ArrayDeque<Int> = ArrayDeque()
        stack.add(node)
        var size = 0

        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            if (!citiesVisited[current]) {
                citiesVisited[current] = true
                size++
                for (neighbor in graph[current]) {
                    if (!citiesVisited[neighbor]) stack.add(neighbor)
                }
            }
        }
        return size
    }

    fun bfs(node: Int): Int {
        val queue: ArrayDeque<Int> = ArrayDeque()
        queue.add(node)
        var size = 0
        citiesVisited[node] = true

        while (queue.isNotEmpty()) {
            val currentNode = queue.removeFirst()
            size++
            for (neighbor in graph[currentNode]) {
                if (!citiesVisited[neighbor]) {
                    citiesVisited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }
        return size
    }

    var totalCost = 0L
    for (i in 1..citiesNumber) {
        if (!citiesVisited[i]) {
            val componentSize = dfs(i)
            totalCost += libraryCost + (componentSize - 1) * roadCost
        }
    }

    return totalCost
}


fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val c_lib = first_multiple_input[2].toInt()

        val c_road = first_multiple_input[3].toInt()

        val cities = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })

        for (i in 0 until m) {
            cities[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        val result = roadsAndLibraries(citiesNumber = n, c_lib, c_road, cities)

        println(result)
    }
}

