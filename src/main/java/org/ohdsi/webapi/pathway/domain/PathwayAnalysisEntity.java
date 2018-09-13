package org.ohdsi.webapi.pathway.domain;

import org.ohdsi.webapi.model.CommonEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "pathway_analyses")
public class PathwayAnalysisEntity extends CommonEntity {

    @Id
    @SequenceGenerator(name = "pathways_analyses_pk_sequence", sequenceName = "pathway_analyses_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pathways_analyses_pk_sequence")
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "pathwayAnalysis", cascade = CascadeType.ALL)
    private List<PathwayTargetCohort> targetCohorts = new ArrayList<>();

    @OneToMany(mappedBy = "pathwayAnalysis", cascade = CascadeType.ALL)
    private List<PathwayEventCohort> eventCohorts = new ArrayList<>();

    @Column(name = "combination_window")
    private Integer combinationWindow;

    @Column(name = "min_cell_count")
    private Integer minCellCount;

    @Column(name = "max_depth")
    private Integer maxDepth;

    @Column(name = "hash_code")
    private Integer hashCode;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<PathwayTargetCohort> getTargetCohorts() {

        return targetCohorts;
    }

    public void setTargetCohorts(List<PathwayTargetCohort> targetCohorts) {

        this.targetCohorts = targetCohorts;
    }

    public List<PathwayEventCohort> getEventCohorts() {

        return eventCohorts;
    }

    public void setEventCohorts(List<PathwayEventCohort> eventCohorts) {

        this.eventCohorts = eventCohorts;
    }

    public Integer getCombinationWindow() {

        return combinationWindow;
    }

    public void setCombinationWindow(Integer combinationWindow) {

        this.combinationWindow = combinationWindow;
    }

    public Integer getMinCellCount() {

        return minCellCount;
    }

    public void setMinCellCount(Integer minCellCount) {

        this.minCellCount = minCellCount;
    }

    public Integer getMaxDepth() {

        return maxDepth;
    }

    public void setMaxDepth(Integer maxDepth) {

        this.maxDepth = maxDepth;
    }

    public Integer getHashCode() {

        return hashCode;
    }

    public void setHashCode(Integer hashCode) {

        this.hashCode = hashCode;
    }
}
