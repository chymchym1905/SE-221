package com.uwc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.uwc.service.MCPService;
import com.uwc.service.RouteService;

import net.bytebuddy.asm.Advice.This;

import org.jgrapht.*;
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
	
	//Graph<URI, DefaultEdge> graph =  new WeightedMultigraph();
	
	
}
