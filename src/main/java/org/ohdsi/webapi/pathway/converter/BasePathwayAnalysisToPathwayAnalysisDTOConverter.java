package org.ohdsi.webapi.pathway.converter;

import org.ohdsi.webapi.user.dto.UserDTO;
import org.ohdsi.webapi.converter.BaseConversionServiceAwareConverter;
import org.ohdsi.webapi.pathway.domain.PathwayAnalysisEntity;
import org.ohdsi.webapi.pathway.dto.BasePathwayAnalysisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

public abstract class BasePathwayAnalysisToPathwayAnalysisDTOConverter<T extends BasePathwayAnalysisDTO> extends BaseConversionServiceAwareConverter<PathwayAnalysisEntity, T> {

    @Autowired
    protected ConversionService conversionService;

    @Override
    public T convert(PathwayAnalysisEntity source) {

        T dto = getTargetObject();

        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setCombinationWindow(source.getCombinationWindow());
        dto.setMinCellCount(source.getMinCellCount());
        dto.setMaxDepth(source.getMaxDepth());
        dto.setCreatedBy(conversionService.convert(source.getCreatedBy(), UserDTO.class));
        dto.setCreatedAt(source.getCreatedAt());
        dto.setUpdatedBy(conversionService.convert(source.getUpdatedBy(), UserDTO.class));
        dto.setUpdatedAt(source.getUpdatedAt());

        return dto;
    }

    protected abstract T getTargetObject();
}