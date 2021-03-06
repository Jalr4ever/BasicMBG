> Basic MyBatis Generation，MyBatis 的逆向生成工具，来源：[ liujun - MyMGB](https://gitee.com/junliu92/MyMGB/tree/master)
>
> MyBatis 逆向生成工具可谓是家中常备
>
> 某些时候往往就需要一个小工具来简单生成一些东西，记得老东家有部署过规范的，今天找了一下午也没搞到个老东家那味儿的，一些还甚至很多问题，于是今天在码云找到个简单的，做个简单的说明文档，收藏一下

# 制品

> 先看看这些制品是否是你的预期内容，再决定是否 clone 这个工具使用

生成了哪些制品？使用这个工具可以生成对应表的 `mapper.java`、`mapper.xml`、`entity.java`

例如，对表 `tb_system_log_info` 配置好的生成实例：

实体类：

```java
public class TbSystemLogInfo {
    private Long id;

    private Integer eventId;

    private String description;

    private Short operate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Short getOperate() {
        return operate;
    }

    public void setOperate(Short operate) {
        this.operate = operate;
    }
}
```

Mapper 接口类：

```java
public interface TbSystemLogInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbSystemLogInfo record);

    int insertSelective(TbSystemLogInfo record);

    TbSystemLogInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSystemLogInfo record);

    int updateByPrimaryKey(TbSystemLogInfo record);
}
```

Mapper 接口对应 xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.auth.mapper.TbSystemLogInfoMapper">
  <resultMap id="BaseResultMap" type="com.pojo.entity.TbSystemLogInfo">
    <id column="id" jdbcType="BIGINT" property="id" />
    <result column="event_id" jdbcType="INTEGER" property="eventId" />
    <result column="description" jdbcType="VARCHAR" property="description" />
    <result column="operate" jdbcType="SMALLINT" property="operate" />
  </resultMap>
  <sql id="Base_Column_List">
    id, event_id, description, operate
  </sql>
  <select id="selectByPrimaryKey" parameterType="java.lang.Long" resultMap="BaseResultMap">
    select 
    <include refid="Base_Column_List" />
    from tb_system_log_info
    where id = #{id,jdbcType=BIGINT}
  </select>
  <delete id="deleteByPrimaryKey" parameterType="java.lang.Long">
    delete from tb_system_log_info
    where id = #{id,jdbcType=BIGINT}
  </delete>
  <insert id="insert" parameterType="com.pojo.entity.TbSystemLogInfo">
    insert into tb_system_log_info (id, event_id, description, 
      operate)
    values (#{id,jdbcType=BIGINT}, #{eventId,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, 
      #{operate,jdbcType=SMALLINT})
  </insert>
  <insert id="insertSelective" parameterType="com.pojo.entity.TbSystemLogInfo">
    insert into tb_system_log_info
    <trim prefix="(" suffix=")" suffixOverrides=",">
      <if test="id != null">
        id,
      </if>
      <if test="eventId != null">
        event_id,
      </if>
      <if test="description != null">
        description,
      </if>
      <if test="operate != null">
        operate,
      </if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
      <if test="id != null">
        #{id,jdbcType=BIGINT},
      </if>
      <if test="eventId != null">
        #{eventId,jdbcType=INTEGER},
      </if>
      <if test="description != null">
        #{description,jdbcType=VARCHAR},
      </if>
      <if test="operate != null">
        #{operate,jdbcType=SMALLINT},
      </if>
    </trim>
  </insert>
  <update id="updateByPrimaryKeySelective" parameterType="com.pojo.entity.TbSystemLogInfo">
    update tb_system_log_info
    <set>
      <if test="eventId != null">
        event_id = #{eventId,jdbcType=INTEGER},
      </if>
      <if test="description != null">
        description = #{description,jdbcType=VARCHAR},
      </if>
      <if test="operate != null">
        operate = #{operate,jdbcType=SMALLINT},
      </if>
    </set>
    where id = #{id,jdbcType=BIGINT}
  </update>
  <update id="updateByPrimaryKey" parameterType="com.pojo.entity.TbSystemLogInfo">
    update tb_system_log_info
    set event_id = #{eventId,jdbcType=INTEGER},
      description = #{description,jdbcType=VARCHAR},
      operate = #{operate,jdbcType=SMALLINT}
    where id = #{id,jdbcType=BIGINT}
  </update>
</mapper>
```

# 使用

- git clone
- 由于是 Maven 工程，所以使用 IDEA / Eclipse 打开都可以

接着需要做相应的配置，在工程的 `\resource\` 目录下有 `generatorConfig.xml` ，需要修改 xml 节点项：

- `<classPathEntry>`，项目的 lib 就是驱动包，这个节点中的路径指向这个文件的绝对路径即可，目前工程附带的是 mysql 的，其他数据库驱动同理
- `<jdbcConnection>`，注意的是要转移 connectionURL中的 `&` 为 `&amp;`
- `<javaModelGenerator>`
- `<sqlMapGenerator>`
- `<javaClientGenerator>`
- `<table>`

节点项意义在源代码中都有相应的中文说明，需要注意的是，**`generatorConfig.xml` 中节点的顺序不可随意更改，否则就报错！**

配置完成后，在工程的 `\org\mybatis\generator\StartUp` 中启动即可

Enjoy！