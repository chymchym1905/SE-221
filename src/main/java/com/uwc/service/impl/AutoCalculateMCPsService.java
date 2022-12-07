package com.uwc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.uwc.dto.MCPDto;
import com.uwc.dto.RouteDto;
import com.uwc.service.MCPService;
import com.uwc.service.RouteService;

import net.bytebuddy.asm.Advice.This;

import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class AutoCalculateMCPsService {
	
	@Autowired
	private MCPService mcpService;
	
	@Autowired
	private RouteService routeService;
	
	public void CalculateDistance() {
		
		RouteDto routeDto;
		Random r = new Random();
		List<MCPDto> mcps = mcpService.findAll();
		Graph<MCPDto, DefaultWeightedEdge> graph =  new WeightedMultigraph<>(DefaultWeightedEdge.class);
		
		for (MCPDto mcp : mcps) {
			graph.addVertex(mcp);
		}
		
		List<DefaultWeightedEdge> listEdges = new ArrayList<DefaultWeightedEdge>();
		for (int i = 0; i < mcps.size() - 1 ; i ++) {
			for (int j = 1; i < mcps.size(); i ++) {
				DefaultWeightedEdge edge = graph.addEdge(mcps[i], mcps[j]);
				listEdges.add(edge);
			}
		}
		
		double randomValue; 
		
		for (DefaultWeightedEdge edge : listEdges) {
			randomValue = 0 + (100 - 0) * r.nextDouble();
			graph.setEdgeWeight(edge, randomValue);
		}
		
		 DijkstraShortestPath<MCPDto, DefaultWeightedEdge> dijkstraAlg =
		            new DijkstraShortestPath<MCPDto, DefaultWeightedEdge>(graph);
		 
		 	List<MCPDto> shortestPath_dijkstra = dijkstraAlg
			        .getPath(mcps[0], mcps[1]) // from mcp0 to mcp1
			        .getVertexList();
		 	
	       
	        BellmanFordShortestPath<MCPDto, DefaultWeightedEdge> bellmanFordShortestPath 
	        = new BellmanFordShortestPath<MCPDto, DefaultWeightedEdge>(graph);
	        
	        List<MCPDto> shortestPath_Bellam = bellmanFordShortestPath
				        .getPath(mcps[0], mcps[1]) // from mcp0 to mcp1
				        .getVertexList();
	        
	        Set<MCPDto> targetMCP_Dijkstra = new HashSet<>(shortestPath_dijkstra);
	        Set<MCPDto> targetMCP_Bellam = new HashSet<>(shortestPath_Bellam);
	        
	        
	        routeDto = new RouteDto(1, "abc", shortestPath_Bellam.size(), 0, targetMCP_Dijkstra);
	        
	        routeService.add(routeDto);	
	}
	
}
