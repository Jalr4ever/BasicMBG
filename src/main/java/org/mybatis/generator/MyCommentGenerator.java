package org.mybatis.generator;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * @Title: MyCommentGenerator.java
 * @Package com.fendo.mybatis_generator_plus
 * @Description: mybatis generator �Զ���comment������. ����MBG 1.3.5
 * @author fendo
 * @date 2017��10��5�� ����3:07:26
 * @version V1.0
 */
public class MyCommentGenerator implements CommentGenerator {

	/**
	 * properties�����ļ�
	 */
	private Properties properties;
	/**
	 * properties�����ļ�
	 */
	private Properties systemPro;

	/*
	 * ����ʱ��
	 */
	private boolean suppressDate;

	/**
	 * ��������ע��
	 */
	private boolean suppressAllComments;

	/**
	 * ��ǰʱ��
	 */
	private String currentDateStr;

	public MyCommentGenerator() {
		super();
		properties = new Properties();
		systemPro = System.getProperties();
		suppressDate = false;
		suppressAllComments = false;
		currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}

	/**
	 * Java�����ע��
	 */
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" ");
		sb.append(getDateString());
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		innerClass.addJavaDocLine(" */");
	}

	/**
	 * Ϊ�����ע��
	 */
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		sb.setLength(0);
		sb.append(" * @author ");
		sb.append(systemPro.getProperty("user.name"));
		sb.append(" ");
		sb.append(currentDateStr);
		innerClass.addJavaDocLine(" */");
	}

	/**
	 * Mybatis��Mapper.xml�ļ������ע��
	 */
	@Override
	public void addComment(XmlElement xmlElement) {

	}

	/**
	 * 
	 * @Title addConfigurationProperties @Description:
	 * �Ӹ������е��κ�������Ӵ�ʵ��������CommentGenerator���á� ������������κ���������֮ǰ�����á� @Author fendo @Date
	 * 2017��10��5�� ����3:45:58 @return @throws
	 */
	@Override
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
		suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
		suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	/**
	 * 
	 * @Title getDateString @Description: �˷������ظ�ʽ���������ַ����԰�����Javadoc����к�XMLע�͡�
	 * ���������Ҫ���ڣ�����Է���null����Щ�ĵ�Ԫ���С� @Author fendo @Date 2017��10��5��
	 * ����3:45:58 @return @throws
	 */
	protected String getDateString() {
		String result = null;
		if (!suppressDate) {
			result = currentDateStr;
		}
		return result;
	}

	/**
	 * 
	 * @Title addJavadocTag @Description: �˷���Ϊ��������Զ���javadoc��ǩ�� @Author fendo @Date
	 * 2017��10��5�� ����3:49:05 @param javaElement @param markAsDoNotDelete @throws
	 */
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		javaElement.addJavaDocLine(" *");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		if (markAsDoNotDelete) {
			sb.append(" do_not_delete_during_merge");
		}
		String s = getDateString();
		if (s != null) {
			sb.append(' ');
			sb.append(s);
		}
		javaElement.addJavaDocLine(sb.toString());
	}

	/**
	 * Ϊö�����ע��
	 */
	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		innerEnum.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
		innerEnum.addJavaDocLine(" */");
	}

	/**
	 * Java����ע��
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		field.addJavaDocLine(sb.toString().replace("\n", " "));
		field.addJavaDocLine(" */");

	}

	/**
	 * Ϊ�ֶ����ע��
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		field.addJavaDocLine(sb.toString().replace("\n", " "));
		field.addJavaDocLine(" */");
	}

	/**
	 * ��ͨ������ע�ͣ�������Ҫ��XXXMapper.java����Ľӿڷ�����ע��
	 */
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	/**
	 * ��getter������ע��
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n", " "));
		sb.setLength(0);
		sb.append(" * @return ");
		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n", " "));
		method.addJavaDocLine(" */");
	}

	/**
	 * ��Java�ļ���ע�ͣ����ע�������ļ��Ķ�����Ҳ����package���档
	 */
	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		compilationUnit.addFileCommentLine("/*");
		compilationUnit.addFileCommentLine("*");
		compilationUnit.addFileCommentLine("* " + compilationUnit.getType().getShortName() + ".java");
		compilationUnit.addFileCommentLine("* Copyright(C) 2017-2020 fendo��˾");
		compilationUnit.addFileCommentLine("* @date " + sdf.format(new Date()) + "");
		compilationUnit.addFileCommentLine("*/");
	}

	/**
	 * Ϊģ�������ע��
	 */
	@Override
	public void addModelClassComment(TopLevelClass arg0, IntrospectedTable arg1) {

	}

	/**
	 * Ϊ���ô˷�����Ϊ��Ԫ�صĵ�һ���ӽڵ����ע�͡�
	 */
	@Override
	public void addRootComment(XmlElement arg0) {

	}

	/**
	 * ��setter������ע��
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n", " "));
		Parameter parm = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param ");
		sb.append(parm.getName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n", " "));
		method.addJavaDocLine(" */");
	}

}
