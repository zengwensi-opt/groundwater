package ${package.Mapper};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
*
* ${table.comment!} Mapper 接口
*
* @author ${author}
* @since ${date}
*/
@Mapper
public interface ${table.mapperName} extends BaseMapper<${entity}>  {

}