package com.plcoding.jetpackcomposemasterclass.algorithms

import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'bfs' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER m
 *  3. 2D_INTEGER_ARRAY edges
 *  4. INTEGER s
 */

fun bfs(nodeNumber: Int, edgesNumber: Int, edges: Array<Array<Int>>, initialNode: Int): Array<Int> {
    val graph = Array(nodeNumber + 1) { mutableListOf<Int>() }
    for (edge in edges) {
        val u = edge[0]
        val v = edge[1]
        graph[u].add(v)
        graph[v].add(u) // Grafo no dirigido
    }

    val distances = Array(nodeNumber + 1) { -1 }
    distances[initialNode] = 0 // Distancia al nodo inicial es 0

    // Implementar BFS
    val queue: ArrayDeque<Int> = ArrayDeque()
    queue.add(initialNode)

    while (queue.isNotEmpty()) {
        val currentNode = queue.removeFirst()
        for (neighbor in graph[currentNode]) {
            if (distances[neighbor] == -1) {
                distances[neighbor] = distances[currentNode] + 6
                queue.add(neighbor)
            }
        }
    }

    return distances.sliceArray(1..nodeNumber)
        .filterIndexed { index, _ -> index + 1 != initialNode }.toTypedArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val edges = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })

        for (i in 0 until m) {
            edges[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        val s = readLine()!!.trim().toInt()

        val result = bfs(nodeNumber = n, edgesNumber = m, edges = edges, initialNode = s)

        println(result.joinToString(" "))
    }
}
