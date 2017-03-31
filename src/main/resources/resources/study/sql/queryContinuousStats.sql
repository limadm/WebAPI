select TOP 5000
	ar1.covariate_id,
	ar1.covariate_name, 
	ar1.analysis_id,
	ar1.analysis_name, 
	ar1.domain_id,
	ar1.time_window,
	ar1.concept_id,
	sr1.count_value, 
	sr1.min_value, 
	sr1.max_value, 
	sr1.avg_value, 
	sr1.stdev_value, 
	sr1.median_value, 
	sr1.p10_value, 
	sr1.p25_value, 
	sr1.p75_value, 
	sr1.p90_value
from @results_database_schema.as_cohort_summary_analysis_ref ar1
inner join @results_database_schema.as_cohort_summary_results_dist sr1 on ar1.covariate_id = sr1.covariate_id
left join @cdm_database_schema.CONCEPT c on ar1.concept_id = c.concept_id
where sr1.cohort_definition_id = @cohort_definition_id @criteria_clauses
ORDER BY sr1.count_value DESC
