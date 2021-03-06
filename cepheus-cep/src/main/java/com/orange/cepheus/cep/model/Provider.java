/*
 * Copyright (C) 2015 Orange
 *
 * This software is distributed under the terms and conditions of the 'GNU GENERAL PUBLIC LICENSE
 * Version 2' license which can be found in the file 'LICENSE.txt' in this package distribution or
 * at 'http://www.gnu.org/licenses/gpl-2.0-standalone.html'.
 */

package com.orange.cepheus.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.Instant;
import java.util.Objects;

/**
 * Provider defines the URL of one of the providers of a EventTypeIn.
 */
public class Provider {

    /**
     * URL of the provider
     */
    private String url;

    /**
     * Date of last successful subscription.
     * Used by the SubscriptionManager to track valid subscriptions
     */
    @JsonIgnore
    private Instant subscriptionDate;

    /**
     * Id of the subscription
     * Used by the SubscriptionManager to track valid subscriptions
     */
    @JsonIgnore
    private String subscriptionId;
    /**
     * Fiware specific service name (optional)
     */
    private String serviceName;

    /**
     * Fiware specific service path (optional)
     */
    private String servicePath;

    /**
     * Constructor used by Jackson for deserialization
     * @param url the URL of the provider
     */
    public Provider(String url) {
        this.url = url;
    }
	
    public Provider(){
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Instant getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Instant subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    
    public String getServiceName() {
	return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePath() {
        return servicePath;
    }
	
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }
    
    public boolean hasSameOrigin(Provider otherProvider) {
		if (otherProvider != null) {
			if (otherProvider.url != null && !otherProvider.url.isEmpty()) {
				return url.equals(otherProvider.url)
						&& (Objects.equals(servicePath,
								otherProvider.servicePath))
						&& (Objects.equals(serviceName,
								otherProvider.serviceName));
			}
		}
		return false;
	}
}
