package com.graphqljava.tutorial.TpGraphql;

import graphql.schema.DataFetchingEnvironment;

public interface DataFetcher<T> {
	T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
