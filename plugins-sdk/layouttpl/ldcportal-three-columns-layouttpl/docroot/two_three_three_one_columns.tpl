<div class="two_three_three_one_columns" id="main-content" role="main">
	#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
	<table class="portlet-layout">
		<tr>
			<td class="aui-w70 portlet-column portlet-column-first">
				<table class="portlet-layout">
					<tr>
						<td class="portlet-column portlet-column-only" id="column-2">
							$processor.processColumn("column-2", "portlet-column-content
							portlet-column-content-only")</td>
					</tr>
				</table>
				<table class="portlet-layout three-columns-portlet-layout">
					<tr>
						<td class="aui-w33 portlet-column portlet-column-first special-un-column" id="column-4">
							$processor.processColumn("column-4", "portlet-column-content
							portlet-column-content-first")</td>
						<td class="aui-w33 portlet-column special-un-column special-un-colum-middle" id="column-5">
							$processor.processColumn("column-5", "portlet-column-content")</td>
						<td class="aui-w33 portlet-column portlet-column-last special-un-column" id="column-6">
							$processor.processColumn("column-6", "portlet-column-content
							portlet-column-content-last")</td>
					</tr>
				</table>
				<table class="portlet-layout three-columns-portlet-layout">
					<tr>
						<td class="aui-w33 portlet-column portlet-column-first special-un-column" id="column-8">
							$processor.processColumn("column-8", "portlet-column-content
							portlet-column-content-first")</td>
						<td class="aui-w33 portlet-column special-un-column special-un-column-middle" id="column-9">
							$processor.processColumn("column-9", "portlet-column-content")</td>
						<td class="aui-w33 portlet-column portlet-column-last special-un-column" id="column-10">
							$processor.processColumn("column-10", "portlet-column-content
							portlet-column-content-last")</td>
					</tr>
				</table>
				<table class="portlet-layout">
					<tr>
						<td class="portlet-column portlet-column-only" id="column-7">
							$processor.processColumn("column-7", "portlet-column-content
							portlet-column-content-only")</td>
					</tr>
				</table>
			</td>
			<td class="aui-w30 portlet-column portlet-column-last" id="column-3">
				$processor.processColumn("column-3", "portlet-column-content
				portlet-column-content-last")</td>
		</tr>
	</table>
	#else
	<div class="portlet-layout">
		<div class="aui-w70 portlet-column portlet-column-first">
			<div class="portlet-layout">
				<div class="portlet-column portlet-column-only" id="column-2">
					$processor.processColumn("column-2", "portlet-column-content
					portlet-column-content-only")</div>
			</div>
			<div class="portlet-layout three-columns-portlet-layout">
				<div class="aui-w33 portlet-column portlet-column-first special-un-column" id="column-4">
					$processor.processColumn("column-4", "portlet-column-content
					portlet-column-content-first")</div>
				<div class="aui-w33 portlet-column special-un-column special-un-colum-middle" id="column-5">
					$processor.processColumn("column-5", "portlet-column-content")</div>
				<div class="aui-w33 portlet-column portlet-column-last special-un-column" id="column-6">
					$processor.processColumn("column-6", "portlet-column-content
					portlet-column-content-last")</div>
			</div>
			<div class="portlet-layout three-columns-portlet-layout">
				<div class="aui-w33 portlet-column portlet-column-first special-un-column" id="column-8">
					$processor.processColumn("column-8", "portlet-column-content
					portlet-column-content-first")</div>
				<div class="aui-w33 portlet-column special-un-column special-un-column-middle" id="column-9">
					$processor.processColumn("column-9", "portlet-column-content")</div>
				<div class="aui-w33 portlet-column portlet-column-last special-un-column" id="column-10">
					$processor.processColumn("column-10", "portlet-column-content
					portlet-column-content-last")</div>
			</div>
			<div class="portlet-layout">
				<div class="portlet-column portlet-column-only" id="column-7">
					$processor.processColumn("column-7", "portlet-column-content
					portlet-column-content-only")</div>
			</div>
		</div>
		<div class="aui-w30 portlet-column portlet-column-last special-right-column" id="column-3">
			$processor.processColumn("column-3", "portlet-column-content
			portlet-column-content-last")</div>
	</div>
	#end
</div>
