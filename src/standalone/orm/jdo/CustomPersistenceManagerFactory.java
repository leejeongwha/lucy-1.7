package orm.jdo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.jdo.FetchGroup;
import javax.jdo.JDOEnhancer;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.datastore.DataStoreCache;
import javax.jdo.listener.InstanceLifecycleListener;
import javax.jdo.metadata.JDOMetadata;
import javax.jdo.metadata.TypeMetadata;

import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;

public class CustomPersistenceManagerFactory extends JDOPersistenceManagerFactory {
	private static final long serialVersionUID = -2762990747896420753L;

	private PersistenceManagerFactory factory;
	
	private Map<String, ?> props;
	
	private List<String> classList;
	
	public void init() {
		JDOEnhancer enhancer = JDOHelper.getEnhancer();
		enhancer.setClassLoader(getClass().getClassLoader());
		
		for (String  claz : classList) {
			enhancer.addClasses(claz);
		}
		
		enhancer.enhance();
		
		this.factory = JDOHelper.getPersistenceManagerFactory(props, getClass().getClassLoader());
	}

	public void close() {
		factory.close();
	}

	public boolean isClosed() {
		return factory.isClosed();
	}

	public PersistenceManager getPersistenceManager() {
		return factory.getPersistenceManager();
	}

	public PersistenceManager getPersistenceManagerProxy() {
		return factory.getPersistenceManagerProxy();
	}

	public PersistenceManager getPersistenceManager(String userid,
			String password) {
		return factory.getPersistenceManager(userid, password);
	}

	public void setConnectionUserName(String userName) {
		factory.setConnectionUserName(userName);
	}

	public String getConnectionUserName() {
		return factory.getConnectionUserName();
	}

	public void setConnectionPassword(String password) {
		factory.setConnectionPassword(password);
	}

	public void setConnectionURL(String url) {
		factory.setConnectionURL(url);
	}

	public String getConnectionURL() {
		return factory.getConnectionURL();
	}

	public void setConnectionDriverName(String driverName) {
		factory.setConnectionDriverName(driverName);
	}

	public String getConnectionDriverName() {
		return factory.getConnectionDriverName();
	}

	public void setConnectionFactoryName(String connectionFactoryName) {
		factory.setConnectionFactoryName(connectionFactoryName);
	}

	public String getConnectionFactoryName() {
		return factory.getConnectionFactoryName();
	}

	public void setConnectionFactory(Object connectionFactory) {
		factory.setConnectionFactory(connectionFactory);
	}

	public Object getConnectionFactory() {
		return factory.getConnectionFactory();
	}

	public void setConnectionFactory2Name(String connectionFactoryName) {
		factory.setConnectionFactory2Name(connectionFactoryName);
	}

	public String getConnectionFactory2Name() {
		return factory.getConnectionFactory2Name();
	}

	public void setConnectionFactory2(Object connectionFactory) {
		factory.setConnectionFactory2(connectionFactory);
	}

	public Object getConnectionFactory2() {
		return factory.getConnectionFactory2();
	}

	public void setMultithreaded(boolean flag) {
		factory.setMultithreaded(flag);
	}

	public boolean getMultithreaded() {
		return factory.getMultithreaded();
	}

	public void setMapping(String mapping) {
		factory.setMapping(mapping);
	}

	public String getMapping() {
		return factory.getMapping();
	}

	public void setOptimistic(boolean flag) {
		factory.setOptimistic(flag);
	}

	public boolean getOptimistic() {
		return factory.getOptimistic();
	}

	public void setRetainValues(boolean flag) {
		factory.setRetainValues(flag);
	}

	public boolean getRetainValues() {
		return factory.getRetainValues();
	}

	public void setRestoreValues(boolean restoreValues) {
		factory.setRestoreValues(restoreValues);
	}

	public boolean getRestoreValues() {
		return factory.getRestoreValues();
	}

	public void setNontransactionalRead(boolean flag) {
		factory.setNontransactionalRead(flag);
	}

	public boolean getNontransactionalRead() {
		return factory.getNontransactionalRead();
	}

	public void setNontransactionalWrite(boolean flag) {
		factory.setNontransactionalWrite(flag);
	}

	public boolean getNontransactionalWrite() {
		return factory.getNontransactionalWrite();
	}

	public void setIgnoreCache(boolean flag) {
		factory.setIgnoreCache(flag);
	}

	public boolean getIgnoreCache() {
		return factory.getIgnoreCache();
	}

	public boolean getDetachAllOnCommit() {
		return factory.getDetachAllOnCommit();
	}

	public void setDetachAllOnCommit(boolean flag) {
		factory.setDetachAllOnCommit(flag);
	}

	public boolean getCopyOnAttach() {
		return factory.getCopyOnAttach();
	}

	public void setCopyOnAttach(boolean flag) {
		factory.setCopyOnAttach(flag);
	}

	public void setName(String name) {
		factory.setName(name);
	}

	public String getName() {
		return factory.getName();
	}

	public void setPersistenceUnitName(String name) {
		factory.setPersistenceUnitName(name);
	}

	public String getPersistenceUnitName() {
		return factory.getPersistenceUnitName();
	}

	public void setServerTimeZoneID(String timezoneid) {
		factory.setServerTimeZoneID(timezoneid);
	}

	public String getServerTimeZoneID() {
		return factory.getServerTimeZoneID();
	}

	public void setTransactionType(String name) {
		factory.setTransactionType(name);
	}

	public String getTransactionType() {
		return factory.getTransactionType();
	}

	public boolean getReadOnly() {
		return factory.getReadOnly();
	}

	public void setReadOnly(boolean flag) {
		factory.setReadOnly(flag);
	}

	public String getTransactionIsolationLevel() {
		return factory.getTransactionIsolationLevel();
	}

	public void setTransactionIsolationLevel(String level) {
		factory.setTransactionIsolationLevel(level);
	}

	public void setDatastoreReadTimeoutMillis(Integer interval) {
		factory.setDatastoreReadTimeoutMillis(interval);
	}

	public Integer getDatastoreReadTimeoutMillis() {
		return factory.getDatastoreReadTimeoutMillis();
	}

	public void setDatastoreWriteTimeoutMillis(Integer interval) {
		factory.setDatastoreWriteTimeoutMillis(interval);
	}

	public Integer getDatastoreWriteTimeoutMillis() {
		return factory.getDatastoreWriteTimeoutMillis();
	}

	public Properties getProperties() {
		return factory.getProperties();
	}

	public Collection<String> supportedOptions() {
		return factory.supportedOptions();
	}

	public DataStoreCache getDataStoreCache() {
		return factory.getDataStoreCache();
	}

	@SuppressWarnings("rawtypes")
	public void addInstanceLifecycleListener(
			InstanceLifecycleListener listener, Class[] classes) {
		factory.addInstanceLifecycleListener(listener, classes);
	}

	public void removeInstanceLifecycleListener(
			InstanceLifecycleListener listener) {
		factory.removeInstanceLifecycleListener(listener);
	}

	public void addFetchGroups(FetchGroup... groups) {
		factory.addFetchGroups(groups);
	}

	public void removeFetchGroups(FetchGroup... groups) {
		factory.removeFetchGroups(groups);
	}

	public void removeAllFetchGroups() {
		factory.removeAllFetchGroups();
	}

	@SuppressWarnings("rawtypes")
	public FetchGroup getFetchGroup(Class cls, String name) {
		return factory.getFetchGroup(cls, name);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set getFetchGroups() {
		return factory.getFetchGroups();
	}

	public void registerMetadata(JDOMetadata metadata) {
		factory.registerMetadata(metadata);
	}

	public JDOMetadata newMetadata() {
		return factory.newMetadata();
	}

	public TypeMetadata getMetadata(String className) {
		return factory.getMetadata(className);
	}

	@SuppressWarnings("rawtypes")
	public Map getProps() {
		return props;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setProps(Map props) {
		this.props = props;
	}

	public List<String> getClassList() {
		return classList;
	}

	public void setClassList(List<String> classList) {
		this.classList = classList;
	}
	
	
}
