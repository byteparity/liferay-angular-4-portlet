/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.byteparity.emp.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.byteparity.emp.model.Employee;
import com.byteparity.emp.model.EmployeeModel;
import com.byteparity.emp.model.EmployeeSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;EMP_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link EmployeeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeImpl
 * @see Employee
 * @see EmployeeModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EmployeeModelImpl extends BaseModelImpl<Employee>
	implements EmployeeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */
	public static final String TABLE_NAME = "EMP_Employee";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "empId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "dob", Types.TIMESTAMP },
			{ "contactNumber", Types.VARCHAR },
			{ "organization", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("empId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dob", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("contactNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("organization", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table EMP_Employee (uuid_ VARCHAR(75) null,empId LONG not null primary key,groupId LONG,companyId LONG,firstName VARCHAR(75) null,lastName VARCHAR(75) null,city VARCHAR(75) null,dob DATE null,contactNumber VARCHAR(75) null,organization VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table EMP_Employee";
	public static final String ORDER_BY_JPQL = " ORDER BY employee.empId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EMP_Employee.empId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.byteparity.emp.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.byteparity.emp.model.Employee"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.byteparity.emp.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.byteparity.emp.model.Employee"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.byteparity.emp.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.byteparity.emp.model.Employee"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long EMPID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Employee toModel(EmployeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Employee model = new EmployeeImpl();

		model.setUuid(soapModel.getUuid());
		model.setEmpId(soapModel.getEmpId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setCity(soapModel.getCity());
		model.setDob(soapModel.getDob());
		model.setContactNumber(soapModel.getContactNumber());
		model.setOrganization(soapModel.getOrganization());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Employee> toModels(EmployeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Employee> models = new ArrayList<Employee>(soapModels.length);

		for (EmployeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.byteparity.emp.service.util.ServiceProps.get(
				"lock.expiration.time.com.byteparity.emp.model.Employee"));

	public EmployeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _empId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("empId", getEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("city", getCity());
		attributes.put("dob", getDob());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("organization", getOrganization());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getEmpId() {
		return _empId;
	}

	@Override
	public void setEmpId(long empId) {
		_empId = empId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public Date getDob() {
		return _dob;
	}

	@Override
	public void setDob(Date dob) {
		_dob = dob;
	}

	@JSON
	@Override
	public String getContactNumber() {
		if (_contactNumber == null) {
			return "";
		}
		else {
			return _contactNumber;
		}
	}

	@Override
	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	@JSON
	@Override
	public String getOrganization() {
		if (_organization == null) {
			return "";
		}
		else {
			return _organization;
		}
	}

	@Override
	public void setOrganization(String organization) {
		_organization = organization;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Employee.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Employee)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setUuid(getUuid());
		employeeImpl.setEmpId(getEmpId());
		employeeImpl.setGroupId(getGroupId());
		employeeImpl.setCompanyId(getCompanyId());
		employeeImpl.setFirstName(getFirstName());
		employeeImpl.setLastName(getLastName());
		employeeImpl.setCity(getCity());
		employeeImpl.setDob(getDob());
		employeeImpl.setContactNumber(getContactNumber());
		employeeImpl.setOrganization(getOrganization());
		employeeImpl.setCreateDate(getCreateDate());
		employeeImpl.setModifiedDate(getModifiedDate());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public int compareTo(Employee employee) {
		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee)obj;

		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		EmployeeModelImpl employeeModelImpl = this;

		employeeModelImpl._originalUuid = employeeModelImpl._uuid;

		employeeModelImpl._originalGroupId = employeeModelImpl._groupId;

		employeeModelImpl._setOriginalGroupId = false;

		employeeModelImpl._originalCompanyId = employeeModelImpl._companyId;

		employeeModelImpl._setOriginalCompanyId = false;

		employeeModelImpl._setModifiedDate = false;

		employeeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.uuid = getUuid();

		String uuid = employeeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			employeeCacheModel.uuid = null;
		}

		employeeCacheModel.empId = getEmpId();

		employeeCacheModel.groupId = getGroupId();

		employeeCacheModel.companyId = getCompanyId();

		employeeCacheModel.firstName = getFirstName();

		String firstName = employeeCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			employeeCacheModel.firstName = null;
		}

		employeeCacheModel.lastName = getLastName();

		String lastName = employeeCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			employeeCacheModel.lastName = null;
		}

		employeeCacheModel.city = getCity();

		String city = employeeCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			employeeCacheModel.city = null;
		}

		Date dob = getDob();

		if (dob != null) {
			employeeCacheModel.dob = dob.getTime();
		}
		else {
			employeeCacheModel.dob = Long.MIN_VALUE;
		}

		employeeCacheModel.contactNumber = getContactNumber();

		String contactNumber = employeeCacheModel.contactNumber;

		if ((contactNumber != null) && (contactNumber.length() == 0)) {
			employeeCacheModel.contactNumber = null;
		}

		employeeCacheModel.organization = getOrganization();

		String organization = employeeCacheModel.organization;

		if ((organization != null) && (organization.length() == 0)) {
			employeeCacheModel.organization = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return employeeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", dob=");
		sb.append(getDob());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", organization=");
		sb.append(getOrganization());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.byteparity.emp.model.Employee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dob</column-name><column-value><![CDATA[");
		sb.append(getDob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organization</column-name><column-value><![CDATA[");
		sb.append(getOrganization());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Employee.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Employee.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _empId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _firstName;
	private String _lastName;
	private String _city;
	private Date _dob;
	private String _contactNumber;
	private String _organization;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Employee _escapedModel;
}