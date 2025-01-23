package com.plcoding.jetpackcomposemasterclass.algorithms

import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'beautifulPath' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. 2D_INTEGER_ARRAY edges
 *  2. INTEGER A
 *  3. INTEGER B
 */

import java.util.PriorityQueue

fun beautifulPath(edges: Array<Array<Int>>, A: Int, B: Int): Int {
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    for (edge in edges) {
        val u = edge[0]
        val v = edge[1]
        val cost = edge[2]

        graph.getOrPut(u) { mutableListOf() }.add(Pair(v, cost))
        graph.getOrPut(v) { mutableListOf() }.add(Pair(u, cost))
    }

    val visited = Array(1025) { BooleanArray(1001) }
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })

    pq.add(Triple(0, A, 0))
    visited[0][A] = true

    while (pq.isNotEmpty()) {
        val (currentPenalty, currentNode, currentCost) = pq.poll()

        if (currentNode == B) {
            return currentPenalty
        }

        for ((neighbor, cost) in graph[currentNode] ?: emptyList()) {
            val newPenalty = currentCost or cost
            if (!visited[newPenalty][neighbor]) {
                visited[newPenalty][neighbor] = true
                pq.add(Triple(newPenalty, neighbor, newPenalty))
            }
        }
    }

    return -1
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val edges = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        edges[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val second_multiple_input = readLine()!!.trimEnd().split(" ")

    val A = second_multiple_input[0].toInt()

    val B = second_multiple_input[1].toInt()

    val result = beautifulPath(edges, A, B)

    println(result)
}

