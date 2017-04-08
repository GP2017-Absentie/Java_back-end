/*
  Copyright (c) 2002, 2016, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.jdbc;

import java.sql.SQLException;

public interface ConnectionProperties {

    /**
     * Returns a description of the connection properties as an XML document.
     * 
     * @return the connection properties as an XML document.
     * @throws SQLException
     *             if an error occurs.
     */
    String exposeAsXml() throws SQLException;

    boolean getAllowLoadLocalInfile();

    boolean getAllowMultiQueries();

    /**
     * @return Returns the allowNanAndInf.
     */
    boolean getAllowNanAndInf();

    /**
     * @return Returns the allowUrlInLocalInfile.
     */
    boolean getAllowUrlInLocalInfile();

    /**
     * @return Returns the alwaysSendSetIsolation.
     */
    boolean getAlwaysSendSetIsolation();

    /**
     * @return Returns the autoDeserialize.
     */
    boolean getAutoDeserialize();

    boolean getAutoGenerateTestcaseScript();

    boolean getAutoReconnectForPools();

    /**
     * @return Returns the blobSendChunkSize.
     */
    int getBlobSendChunkSize();

    /**
     * @return Returns if cacheCallableStatements is enabled
     */
    boolean getCacheCallableStatements();

    /**
     * @return Returns the cachePreparedStatements.
     */
    boolean getCachePreparedStatements();

    boolean getCacheResultSetMetadata();

    /**
     * @return Returns the cacheServerConfiguration.
     */
    boolean getCacheServerConfiguration();

    /**
     * @return Returns the callableStatementCacheSize.
     */
    int getCallableStatementCacheSize();

    boolean getCapitalizeTypeNames();

    /**
     * @return Returns the characterSetResults.
     */
    String getCharacterSetResults();

    /**
     * @return Returns the clobberStreamingResults.
     */
    boolean getClobberStreamingResults();

    String getClobCharacterEncoding();

    /**
     * @return Returns the connectionCollation.
     */
    String getConnectionCollation();

    int getConnectTimeout();

    boolean getContinueBatchOnError();

    boolean getCreateDatabaseIfNotExist();

    int getDefaultFetchSize();

    /**
     * @return Returns the dontTrackOpenResources.
     */
    boolean getDontTrackOpenResources();

    /**
     * @return Returns the dumpQueriesOnException.
     */
    boolean getDumpQueriesOnException();

    /**
     * @return Returns the dynamicCalendars.
     */
    boolean getDynamicCalendars();

    /**
     * @return Returns the elideSetAutoCommits.
     */
    boolean getElideSetAutoCommits();

    boolean getEmptyStringsConvertToZero();

    boolean getEmulateLocators();

    /**
     * @return Returns the emulateUnsupportedPstmts.
     */
    boolean getEmulateUnsupportedPstmts();

    /**
     * @return Returns the enablePacketDebug.
     */
    boolean getEnablePacketDebug();

    String getEncoding();

    /**
     * @return Returns the explainSlowQueries.
     */
    boolean getExplainSlowQueries();

    /**
     * @return Returns the failOverReadOnly.
     */
    boolean getFailOverReadOnly();

    /**
     * @return Returns the gatherPerformanceMetrics.
     */
    boolean getGatherPerformanceMetrics();

    /**
     * @return Returns the holdResultsOpenOverStatementClose.
     */
    boolean getHoldResultsOpenOverStatementClose();

    boolean getIgnoreNonTxTables();

    int getInitialTimeout();

    boolean getInteractiveClient();

    /**
     * @return Returns the isInteractiveClient.
     */
    boolean getIsInteractiveClient();

    /**
     * @return Returns the jdbcCompliantTruncation.
     */
    boolean getJdbcCompliantTruncation();

    /**
     * @return Returns the dontTrackOpenResources.
     */
    int getLocatorFetchBufferSize();

    String getLogger();

    /**
     * @return Returns the loggerClassName.
     */
    String getLoggerClassName();

    /**
     * @return Returns the logSlowQueries.
     */
    boolean getLogSlowQueries();

    boolean getMaintainTimeStats();

    /**
     * @return Returns the maxQuerySizeToLog.
     */
    int getMaxQuerySizeToLog();

    int getMaxReconnects();

    int getMaxRows();

    /**
     * Returns the number of queries that metadata can be cached if caching is
     * enabled.
     * 
     * @return the number of queries to cache metadata for.
     */
    int getMetadataCacheSize();

    /**
     * @return Returns the noDatetimeStringSync.
     */
    boolean getNoDatetimeStringSync();

    boolean getNullCatalogMeansCurrent();

    boolean getNullNamePatternMatchesAll();

    /**
     * @return Returns the packetDebugBufferSize.
     */
    int getPacketDebugBufferSize();

    boolean getParanoid();

    boolean getPedantic();

    /**
     * @return Returns the preparedStatementCacheSize.
     */
    int getPreparedStatementCacheSize();

    /**
     * @return Returns the preparedStatementCacheSqlLimit.
     */
    int getPreparedStatementCacheSqlLimit();

    boolean getProfileSql();

    /**
     * @return Returns the profileSQL flag
     */
    boolean getProfileSQL();

    /**
     * @return Returns the propertiesTransform.
     */
    String getPropertiesTransform();

    int getQueriesBeforeRetryMaster();

    boolean getReconnectAtTxEnd();

    boolean getRelaxAutoCommit();

    /**
     * @return Returns the reportMetricsIntervalMillis.
     */
    int getReportMetricsIntervalMillis();

    boolean getRequireSSL();

    /**
     * @return Returns the rollbackOnPooledClose.
     */
    boolean getRollbackOnPooledClose();

    /**
     * Returns whether or not hosts will be picked in a round-robin fashion.
     * 
     * @return Returns the roundRobinLoadBalance property.
     */
    boolean getRoundRobinLoadBalance();

    /**
     * @return Returns the runningCTS13.
     */
    boolean getRunningCTS13();

    int getSecondsBeforeRetryMaster();

    /**
     * Returns the 'serverTimezone' property.
     * 
     * @return the configured server timezone property.
     */
    String getServerTimezone();

    /**
     * @return Returns the sessionVariables.
     */
    String getSessionVariables();

    /**
     * @return Returns the slowQueryThresholdMillis.
     */
    int getSlowQueryThresholdMillis();

    String getSocketFactoryClassName();

    int getSocketTimeout();

    boolean getStrictFloatingPoint();

    boolean getStrictUpdates();

    /**
     * @return Returns the tinyInt1isBit.
     */
    boolean getTinyInt1isBit();

    /**
     * @return Returns the logProtocol.
     */
    boolean getTraceProtocol();

    boolean getTransformedBitIsBoolean();

    boolean getUseCompression();

    /**
     * @return Returns the useFastIntParsing.
     */
    boolean getUseFastIntParsing();

    boolean getUseHostsInPrivileges();

    boolean getUseInformationSchema();

    /**
     * @return Returns the useLocalSessionState.
     */
    boolean getUseLocalSessionState();

    /**
     * @return Returns the useOldUTF8Behavior.
     */
    boolean getUseOldUTF8Behavior();

    /**
     * @return Returns the useOnlyServerErrorMessages.
     */
    boolean getUseOnlyServerErrorMessages();

    /**
     * @return Returns the useReadAheadInput.
     */
    boolean getUseReadAheadInput();

    boolean getUseServerPreparedStmts();

    /**
     * @return Returns the useSqlStateCodes state.
     */
    boolean getUseSqlStateCodes();

    boolean getUseSSL();

    boolean isUseSSLExplicit();

    boolean getUseStreamLengthsInPrepStmts();

    boolean getUseTimezone();

    boolean getUseUltraDevWorkAround();

    /**
     * @return Returns the useUnbufferedInput.
     */
    boolean getUseUnbufferedInput();

    boolean getUseUnicode();

    /**
     * Returns whether or not the driver advises of proper usage.
     * 
     * @return the value of useUsageAdvisor
     */
    boolean getUseUsageAdvisor();

    boolean getYearIsDateType();

    /**
     * @return Returns the zeroDateTimeBehavior.
     */
    String getZeroDateTimeBehavior();

    void setAllowLoadLocalInfile(boolean property);

    /**
     * @param property
     */
    void setAllowMultiQueries(boolean property);

    /**
     * @param allowNanAndInf
     *            The allowNanAndInf to set.
     */
    void setAllowNanAndInf(boolean flag);

    /**
     * @param allowUrlInLocalInfile
     *            The allowUrlInLocalInfile to set.
     */
    void setAllowUrlInLocalInfile(boolean flag);

    /**
     * @param alwaysSendSetIsolation
     *            The alwaysSendSetIsolation to set.
     */
    void setAlwaysSendSetIsolation(boolean flag);

    /**
     * @param autoDeserialize
     *            The autoDeserialize to set.
     */
    void setAutoDeserialize(boolean flag);

    void setAutoGenerateTestcaseScript(boolean flag);

    /**
     * @param flag
     *            The autoReconnect to set.
     */
    void setAutoReconnect(boolean flag);

    void setAutoReconnectForConnectionPools(boolean property);

    /**
     * @param flag
     *            The autoReconnectForPools to set.
     */
    void setAutoReconnectForPools(boolean flag);

    /**
     * @param blobSendChunkSize
     *            The blobSendChunkSize to set.
     */
    void setBlobSendChunkSize(String value) throws SQLException;

    /**
     * @param flag
     *            The cacheCallableStatements to set.
     */
    void setCacheCallableStatements(boolean flag);

    /**
     * @param flag
     *            The cachePreparedStatements to set.
     */
    void setCachePreparedStatements(boolean flag);

    /**
     * Sets whether or not we should cache result set metadata.
     * 
     * @param property
     */
    void setCacheResultSetMetadata(boolean property);

    /**
     * @param cacheServerConfiguration
     *            The cacheServerConfiguration to set.
     */
    void setCacheServerConfiguration(boolean flag);

    /**
     * Configures the number of callable statements to cache. (this is
     * configurable during the life of the connection).
     * 
     * @param size
     *            The callableStatementCacheSize to set.
     * @throws SQLException
     */
    void setCallableStatementCacheSize(int size) throws SQLException;

    void setCapitalizeDBMDTypes(boolean property);

    /**
     * @param flag
     *            The capitalizeTypeNames to set.
     */
    void setCapitalizeTypeNames(boolean flag);

    /**
     * @param encoding
     *            The characterEncoding to set.
     */
    void setCharacterEncoding(String encoding);

    /**
     * @param characterSet
     *            The characterSetResults to set.
     */
    void setCharacterSetResults(String characterSet);

    /**
     * @param flag
     *            The clobberStreamingResults to set.
     */
    void setClobberStreamingResults(boolean flag);

    void setClobCharacterEncoding(String encoding);

    /**
     * @param collation
     *            The connectionCollation to set.
     */
    void setConnectionCollation(String collation);

    /**
     * @param timeoutMs
     * @throws SQLException
     */
    void setConnectTimeout(int timeoutMs) throws SQLException;

    /**
     * @param property
     */
    void setContinueBatchOnError(boolean property);

    void setCreateDatabaseIfNotExist(boolean flag);

    void setDefaultFetchSize(int n) throws SQLException;

    /**
     * @param property
     */
    void setDetectServerPreparedStmts(boolean property);

    /**
     * @param dontTrackOpenResources
     *            The dontTrackOpenResources to set.
     */
    void setDontTrackOpenResources(boolean flag);

    /**
     * @param flag
     *            The dumpQueriesOnException to set.
     */
    void setDumpQueriesOnException(boolean flag);

    /**
     * @param dynamicCalendars
     *            The dynamicCalendars to set.
     */
    void setDynamicCalendars(boolean flag);

    /**
     * @param flag
     *            The elideSetAutoCommits to set.
     */
    void setElideSetAutoCommits(boolean flag);

    void setEmptyStringsConvertToZero(boolean flag);

    /**
     * @param property
     */
    void setEmulateLocators(boolean property);

    /**
     * @param emulateUnsupportedPstmts
     *            The emulateUnsupportedPstmts to set.
     */
    void setEmulateUnsupportedPstmts(boolean flag);

    /**
     * @param flag
     *            The enablePacketDebug to set.
     */
    void setEnablePacketDebug(boolean flag);

    /**
     * @param property
     */
    void setEncoding(String property);

    /**
     * @param flag
     *            The explainSlowQueries to set.
     */
    void setExplainSlowQueries(boolean flag);

    /**
     * @param flag
     *            The failOverReadOnly to set.
     */
    void setFailOverReadOnly(boolean flag);

    /**
     * @param flag
     *            The gatherPerformanceMetrics to set.
     */
    void setGatherPerformanceMetrics(boolean flag);

    /**
     * @param holdResultsOpenOverStatementClose
     *            The holdResultsOpenOverStatementClose to set.
     */
    void setHoldResultsOpenOverStatementClose(boolean flag);

    /**
     * @param property
     */
    void setIgnoreNonTxTables(boolean property);

    /**
     * @param property
     * @throws SQLException
     */
    void setInitialTimeout(int property) throws SQLException;

    /**
     * @param property
     */
    void setIsInteractiveClient(boolean property);

    /**
     * @param flag
     *            The jdbcCompliantTruncation to set.
     */
    void setJdbcCompliantTruncation(boolean flag);

    /**
     * @param locatorFetchBufferSize
     *            The locatorFetchBufferSize to set.
     */
    void setLocatorFetchBufferSize(String value) throws SQLException;

    /**
     * @param property
     */
    void setLogger(String property);

    /**
     * @param className
     *            The loggerClassName to set.
     */
    void setLoggerClassName(String className);

    /**
     * @param flag
     *            The logSlowQueries to set.
     */
    void setLogSlowQueries(boolean flag);

    void setMaintainTimeStats(boolean flag);

    /**
     * @param sizeInBytes
     *            The maxQuerySizeToLog to set.
     * @throws SQLException
     */
    void setMaxQuerySizeToLog(int sizeInBytes) throws SQLException;

    /**
     * @param property
     * @throws SQLException
     */
    void setMaxReconnects(int property) throws SQLException;

    /**
     * @param property
     * @throws SQLException
     */
    void setMaxRows(int property) throws SQLException;

    /**
     * Sets the number of queries that metadata can be cached if caching is
     * enabled.
     * 
     * @param value
     *            the number of queries to cache metadata for.
     * @throws SQLException
     */
    void setMetadataCacheSize(int value) throws SQLException;

    /**
     * @param noDatetimeStringSync
     *            The noDatetimeStringSync to set.
     */
    void setNoDatetimeStringSync(boolean flag);

    void setNullCatalogMeansCurrent(boolean value);

    void setNullNamePatternMatchesAll(boolean value);

    /**
     * @param size
     *            The packetDebugBufferSize to set.
     * @throws SQLException
     */
    void setPacketDebugBufferSize(int size) throws SQLException;

    /**
     * @param property
     */
    void setParanoid(boolean property);

    /**
     * @param property
     */
    void setPedantic(boolean property);

    /**
     * @param cacheSize
     *            The preparedStatementCacheSize to set.
     * @throws SQLException
     */
    void setPreparedStatementCacheSize(int cacheSize) throws SQLException;

    /**
     * @param cacheSqlLimit
     *            The preparedStatementCacheSqlLimit to set.
     * @throws SQLException
     */
    void setPreparedStatementCacheSqlLimit(int cacheSqlLimit) throws SQLException;

    /**
     * @param property
     */
    void setProfileSql(boolean property);

    /**
     * @param flag
     *            The profileSQL to set.
     */
    void setProfileSQL(boolean flag);

    /**
     * @param propertiesTransform
     *            The propertiesTransform to set.
     */
    void setPropertiesTransform(String value);

    /**
     * @param property
     * @throws SQLException
     */
    void setQueriesBeforeRetryMaster(int property) throws SQLException;

    /**
     * @param property
     */
    void setReconnectAtTxEnd(boolean property);

    /**
     * @param property
     */
    void setRelaxAutoCommit(boolean property);

    /**
     * @param millis
     *            The reportMetricsIntervalMillis to set.
     * @throws SQLException
     */
    void setReportMetricsIntervalMillis(int millis) throws SQLException;

    /**
     * @param property
     */
    void setRequireSSL(boolean property);

    void setRetainStatementAfterResultSetClose(boolean flag);

    /**
     * @param rollbackOnPooledClose
     *            The rollbackOnPooledClose to set.
     */
    void setRollbackOnPooledClose(boolean flag);

    /**
     * Sets whether or not hosts will be picked in a round-robin fashion.
     * 
     * @param flag
     *            The roundRobinLoadBalance property to set.
     */
    void setRoundRobinLoadBalance(boolean flag);

    /**
     * @param runningCTS13
     *            The runningCTS13 to set.
     */
    void setRunningCTS13(boolean flag);

    /**
     * @param property
     * @throws SQLException
     */
    void setSecondsBeforeRetryMaster(int property) throws SQLException;

    /**
     * @param property
     */
    void setServerTimezone(String property);

    /**
     * @param sessionVariables
     *            The sessionVariables to set.
     */
    void setSessionVariables(String variables);

    /**
     * @param millis
     *            The slowQueryThresholdMillis to set.
     * @throws SQLException
     */
    void setSlowQueryThresholdMillis(int millis) throws SQLException;

    /**
     * @param property
     */
    void setSocketFactoryClassName(String property);

    /**
     * @param property
     * @throws SQLException
     */
    void setSocketTimeout(int property) throws SQLException;

    /**
     * @param property
     */
    void setStrictFloatingPoint(boolean property);

    /**
     * @param property
     */
    void setStrictUpdates(boolean property);

    /**
     * @param tinyInt1isBit
     *            The tinyInt1isBit to set.
     */
    void setTinyInt1isBit(boolean flag);

    /**
     * @param flag
     *            The logProtocol to set.
     */
    void setTraceProtocol(boolean flag);

    void setTransformedBitIsBoolean(boolean flag);

    /**
     * @param property
     */
    void setUseCompression(boolean property);

    /**
     * @param useFastIntParsing
     *            The useFastIntParsing to set.
     */
    void setUseFastIntParsing(boolean flag);

    /**
     * @param property
     */
    void setUseHostsInPrivileges(boolean property);

    void setUseInformationSchema(boolean flag);

    /**
     * @param useLocalSessionState
     *            The useLocalSessionState to set.
     */
    void setUseLocalSessionState(boolean flag);

    /**
     * @param useOldUTF8Behavior
     *            The useOldUTF8Behavior to set.
     */
    void setUseOldUTF8Behavior(boolean flag);

    /**
     * @param useOnlyServerErrorMessages
     *            The useOnlyServerErrorMessages to set.
     */
    void setUseOnlyServerErrorMessages(boolean flag);

    /**
     * @param useReadAheadInput
     *            The useReadAheadInput to set.
     */
    void setUseReadAheadInput(boolean flag);

    /**
     * @param flag
     *            The detectServerPreparedStmts to set.
     */
    void setUseServerPreparedStmts(boolean flag);

    /**
     * @param flag
     *            The useSqlStateCodes to set.
     */
    void setUseSqlStateCodes(boolean flag);

    /**
     * @param property
     */
    void setUseSSL(boolean property);

    /**
     * @param property
     */
    void setUseStreamLengthsInPrepStmts(boolean property);

    /**
     * @param property
     */
    void setUseTimezone(boolean property);

    /**
     * @param property
     */
    void setUseUltraDevWorkAround(boolean property);

    /**
     * @param flag
     *            The useUnbufferedInput to set.
     */
    void setUseUnbufferedInput(boolean flag);

    /**
     * @param flag
     *            The useUnicode to set.
     */
    void setUseUnicode(boolean flag);

    /**
     * Sets whether or not the driver advises of proper usage.
     * 
     * @param useUsageAdvisorFlag
     *            whether or not the driver advises of proper usage.
     */
    void setUseUsageAdvisor(boolean useUsageAdvisorFlag);

    void setYearIsDateType(boolean flag);

    /**
     * @param zeroDateTimeBehavior
     *            The zeroDateTimeBehavior to set.
     */
    void setZeroDateTimeBehavior(String behavior);

    /**
     * @return Returns the useUnbufferedInput.
     */
    boolean useUnbufferedInput();

    boolean getUseCursorFetch();

    void setUseCursorFetch(boolean flag);

    boolean getOverrideSupportsIntegrityEnhancementFacility();

    void setOverrideSupportsIntegrityEnhancementFacility(boolean flag);

    boolean getNoTimezoneConversionForTimeType();

    void setNoTimezoneConversionForTimeType(boolean flag);

    boolean getNoTimezoneConversionForDateType();

    void setNoTimezoneConversionForDateType(boolean flag);

    boolean getCacheDefaultTimezone();

    void setCacheDefaultTimezone(boolean flag);

    boolean getUseJDBCCompliantTimezoneShift();

    void setUseJDBCCompliantTimezoneShift(boolean flag);

    boolean getAutoClosePStmtStreams();

    void setAutoClosePStmtStreams(boolean flag);

    boolean getProcessEscapeCodesForPrepStmts();

    void setProcessEscapeCodesForPrepStmts(boolean flag);

    boolean getUseGmtMillisForDatetimes();

    void setUseGmtMillisForDatetimes(boolean flag);

    boolean getDumpMetadataOnColumnNotFound();

    void setDumpMetadataOnColumnNotFound(boolean flag);

    String getResourceId();

    void setResourceId(String resourceId);

    boolean getRewriteBatchedStatements();

    void setRewriteBatchedStatements(boolean flag);

    boolean getJdbcCompliantTruncationForReads();

    void setJdbcCompliantTruncationForReads(boolean jdbcCompliantTruncationForReads);

    boolean getUseJvmCharsetConverters();

    void setUseJvmCharsetConverters(boolean flag);

    boolean getPinGlobalTxToPhysicalConnection();

    void setPinGlobalTxToPhysicalConnection(boolean flag);

    void setGatherPerfMetrics(boolean flag);

    boolean getGatherPerfMetrics();

    void setUltraDevHack(boolean flag);

    boolean getUltraDevHack();

    void setInteractiveClient(boolean property);

    void setSocketFactory(String name);

    String getSocketFactory();

    void setUseServerPrepStmts(boolean flag);

    boolean getUseServerPrepStmts();

    void setCacheCallableStmts(boolean flag);

    boolean getCacheCallableStmts();

    void setCachePrepStmts(boolean flag);

    boolean getCachePrepStmts();

    void setCallableStmtCacheSize(int cacheSize) throws SQLException;

    int getCallableStmtCacheSize();

    void setPrepStmtCacheSize(int cacheSize) throws SQLException;

    int getPrepStmtCacheSize();

    void setPrepStmtCacheSqlLimit(int sqlLimit) throws SQLException;

    int getPrepStmtCacheSqlLimit();

    boolean getNoAccessToProcedureBodies();

    void setNoAccessToProcedureBodies(boolean flag);

    boolean getUseOldAliasMetadataBehavior();

    void setUseOldAliasMetadataBehavior(boolean flag);

    String getClientCertificateKeyStorePassword();

    void setClientCertificateKeyStorePassword(String value);

    String getClientCertificateKeyStoreType();

    void setClientCertificateKeyStoreType(String value);

    String getClientCertificateKeyStoreUrl();

    void setClientCertificateKeyStoreUrl(String value);

    String getTrustCertificateKeyStorePassword();

    void setTrustCertificateKeyStorePassword(String value);

    String getTrustCertificateKeyStoreType();

    void setTrustCertificateKeyStoreType(String value);

    String getTrustCertificateKeyStoreUrl();

    void setTrustCertificateKeyStoreUrl(String value);

    boolean getUseSSPSCompatibleTimezoneShift();

    void setUseSSPSCompatibleTimezoneShift(boolean flag);

    boolean getTreatUtilDateAsTimestamp();

    void setTreatUtilDateAsTimestamp(boolean flag);

    boolean getUseFastDateParsing();

    void setUseFastDateParsing(boolean flag);

    String getLocalSocketAddress();

    void setLocalSocketAddress(String address);

    void setUseConfigs(String configs);

    String getUseConfigs();

    boolean getGenerateSimpleParameterMetadata();

    void setGenerateSimpleParameterMetadata(boolean flag);

    boolean getLogXaCommands();

    void setLogXaCommands(boolean flag);

    int getResultSetSizeThreshold();

    void setResultSetSizeThreshold(int threshold) throws SQLException;

    int getNetTimeoutForStreamingResults();

    void setNetTimeoutForStreamingResults(int value) throws SQLException;

    boolean getEnableQueryTimeouts();

    void setEnableQueryTimeouts(boolean flag);

    boolean getPadCharsWithSpace();

    void setPadCharsWithSpace(boolean flag);

    boolean getUseDynamicCharsetInfo();

    void setUseDynamicCharsetInfo(boolean flag);

    String getClientInfoProvider();

    void setClientInfoProvider(String classname);

    boolean getPopulateInsertRowWithDefaultValues();

    void setPopulateInsertRowWithDefaultValues(boolean flag);

    String getLoadBalanceStrategy();

    void setLoadBalanceStrategy(String strategy);

    boolean getTcpNoDelay();

    void setTcpNoDelay(boolean flag);

    boolean getTcpKeepAlive();

    void setTcpKeepAlive(boolean flag);

    int getTcpRcvBuf();

    void setTcpRcvBuf(int bufSize) throws SQLException;

    int getTcpSndBuf();

    void setTcpSndBuf(int bufSize) throws SQLException;

    int getTcpTrafficClass();

    void setTcpTrafficClass(int classFlags) throws SQLException;

    boolean getUseNanosForElapsedTime();

    void setUseNanosForElapsedTime(boolean flag);

    long getSlowQueryThresholdNanos();

    void setSlowQueryThresholdNanos(long nanos) throws SQLException;

    String getStatementInterceptors();

    void setStatementInterceptors(String value);

    boolean getUseDirectRowUnpack();

    void setUseDirectRowUnpack(boolean flag);

    String getLargeRowSizeThreshold();

    void setLargeRowSizeThreshold(String value) throws SQLException;

    boolean getUseBlobToStoreUTF8OutsideBMP();

    void setUseBlobToStoreUTF8OutsideBMP(boolean flag);

    String getUtf8OutsideBmpExcludedColumnNamePattern();

    void setUtf8OutsideBmpExcludedColumnNamePattern(String regexPattern);

    String getUtf8OutsideBmpIncludedColumnNamePattern();

    void setUtf8OutsideBmpIncludedColumnNamePattern(String regexPattern);

    boolean getIncludeInnodbStatusInDeadlockExceptions();

    void setIncludeInnodbStatusInDeadlockExceptions(boolean flag);

    boolean getIncludeThreadDumpInDeadlockExceptions();

    void setIncludeThreadDumpInDeadlockExceptions(boolean flag);

    boolean getIncludeThreadNamesAsStatementComment();

    void setIncludeThreadNamesAsStatementComment(boolean flag);

    boolean getBlobsAreStrings();

    void setBlobsAreStrings(boolean flag);

    boolean getFunctionsNeverReturnBlobs();

    void setFunctionsNeverReturnBlobs(boolean flag);

    boolean getAutoSlowLog();

    void setAutoSlowLog(boolean flag);

    String getConnectionLifecycleInterceptors();

    void setConnectionLifecycleInterceptors(String interceptors);

    String getProfilerEventHandler();

    void setProfilerEventHandler(String handler);

    boolean getVerifyServerCertificate();

    void setVerifyServerCertificate(boolean flag);

    boolean getUseLegacyDatetimeCode();

    void setUseLegacyDatetimeCode(boolean flag);

    boolean getSendFractionalSeconds();

    void setSendFractionalSeconds(boolean flag);

    int getSelfDestructOnPingSecondsLifetime();

    void setSelfDestructOnPingSecondsLifetime(int seconds) throws SQLException;

    int getSelfDestructOnPingMaxOperations();

    void setSelfDestructOnPingMaxOperations(int maxOperations) throws SQLException;

    boolean getUseColumnNamesInFindColumn();

    void setUseColumnNamesInFindColumn(boolean flag);

    boolean getUseLocalTransactionState();

    void setUseLocalTransactionState(boolean flag);

    boolean getCompensateOnDuplicateKeyUpdateCounts();

    void setCompensateOnDuplicateKeyUpdateCounts(boolean flag);

    void setUseAffectedRows(boolean flag);

    boolean getUseAffectedRows();

    void setPasswordCharacterEncoding(String characterSet);

    String getPasswordCharacterEncoding();

    int getLoadBalanceBlacklistTimeout();

    void setLoadBalanceBlacklistTimeout(int loadBalanceBlacklistTimeout) throws SQLException;

    void setRetriesAllDown(int retriesAllDown) throws SQLException;

    int getRetriesAllDown();

    ExceptionInterceptor getExceptionInterceptor();

    void setExceptionInterceptors(String exceptionInterceptors);

    String getExceptionInterceptors();

    boolean getQueryTimeoutKillsConnection();

    void setQueryTimeoutKillsConnection(boolean queryTimeoutKillsConnection);

    int getMaxAllowedPacket();

    boolean getRetainStatementAfterResultSetClose();

    int getLoadBalancePingTimeout();

    void setLoadBalancePingTimeout(int loadBalancePingTimeout) throws SQLException;

    boolean getLoadBalanceValidateConnectionOnSwapServer();

    void setLoadBalanceValidateConnectionOnSwapServer(boolean loadBalanceValidateConnectionOnSwapServer);

    String getLoadBalanceConnectionGroup();

    void setLoadBalanceConnectionGroup(String loadBalanceConnectionGroup);

    String getLoadBalanceExceptionChecker();

    void setLoadBalanceExceptionChecker(String loadBalanceExceptionChecker);

    String getLoadBalanceSQLStateFailover();

    void setLoadBalanceSQLStateFailover(String loadBalanceSQLStateFailover);

    String getLoadBalanceSQLExceptionSubclassFailover();

    void setLoadBalanceSQLExceptionSubclassFailover(String loadBalanceSQLExceptionSubclassFailover);

    boolean getLoadBalanceEnableJMX();

    void setLoadBalanceEnableJMX(boolean loadBalanceEnableJMX);

    void setLoadBalanceHostRemovalGracePeriod(int loadBalanceHostRemovalGracePeriod) throws SQLException;

    int getLoadBalanceHostRemovalGracePeriod();

    void setLoadBalanceAutoCommitStatementThreshold(int loadBalanceAutoCommitStatementThreshold) throws SQLException;

    int getLoadBalanceAutoCommitStatementThreshold();

    void setLoadBalanceAutoCommitStatementRegex(String loadBalanceAutoCommitStatementRegex);

    String getLoadBalanceAutoCommitStatementRegex();

    void setAuthenticationPlugins(String authenticationPlugins);

    String getAuthenticationPlugins();

    void setDisabledAuthenticationPlugins(String disabledAuthenticationPlugins);

    String getDisabledAuthenticationPlugins();

    void setDefaultAuthenticationPlugin(String defaultAuthenticationPlugin);

    String getDefaultAuthenticationPlugin();

    void setParseInfoCacheFactory(String factoryClassname);

    String getParseInfoCacheFactory();

    void setServerConfigCacheFactory(String factoryClassname);

    String getServerConfigCacheFactory();

    void setDisconnectOnExpiredPasswords(boolean disconnectOnExpiredPasswords);

    boolean getDisconnectOnExpiredPasswords();

    boolean getAllowMasterDownConnections();

    void setAllowMasterDownConnections(boolean connectIfMasterDown);

    boolean getAllowSlaveDownConnections();

    void setAllowSlaveDownConnections(boolean connectIfSlaveDown);

    boolean getReadFromMasterWhenNoSlaves();

    void setReadFromMasterWhenNoSlaves(boolean useMasterIfSlavesDown);

    boolean getReplicationEnableJMX();

    void setReplicationEnableJMX(boolean replicationEnableJMX);

    void setGetProceduresReturnsFunctions(boolean getProcedureReturnsFunctions);

    boolean getGetProceduresReturnsFunctions();

    void setDetectCustomCollations(boolean detectCustomCollations);

    boolean getDetectCustomCollations();

    String getConnectionAttributes() throws SQLException;

    String getServerRSAPublicKeyFile();

    void setServerRSAPublicKeyFile(String serverRSAPublicKeyFile) throws SQLException;

    boolean getAllowPublicKeyRetrieval();

    void setAllowPublicKeyRetrieval(boolean allowPublicKeyRetrieval) throws SQLException;

    void setDontCheckOnDuplicateKeyUpdateInSQL(boolean dontCheckOnDuplicateKeyUpdateInSQL);

    boolean getDontCheckOnDuplicateKeyUpdateInSQL();

    void setSocksProxyHost(String socksProxyHost);

    String getSocksProxyHost();

    void setSocksProxyPort(int socksProxyPort) throws SQLException;

    int getSocksProxyPort();

    boolean getReadOnlyPropagatesToServer();

    void setReadOnlyPropagatesToServer(boolean flag);

    String getEnabledSSLCipherSuites();

    void setEnabledSSLCipherSuites(String cipherSuites);

    boolean getEnableEscapeProcessing();

    void setEnableEscapeProcessing(boolean flag);
}
