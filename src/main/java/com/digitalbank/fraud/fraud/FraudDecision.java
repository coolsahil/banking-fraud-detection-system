package com.digitalbank.fraud.fraud;
public record FraudDecision(int riskScore, boolean flagged, String reason){}
